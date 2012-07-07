package sn.core.persistence.dao.impl;

import java.util.List;

import sn.base.persistence.dao.BaseDao;
import sn.base.util.Constants;
import sn.core.persistence.dao.SnNoticeDao;
import sn.core.persistence.model.SnNotice;

public class SnNoticeDaoImpl extends BaseDao implements SnNoticeDao {

    /**
     * 新增通知
     */
    public boolean add(SnNotice notice) {
        boolean result = false;
        String sql = "INSERT INTO sn_notice(notice_id, user_id, stock_id, title, content, flag, email_result, sms_result, create_time) SELECT IFNULL(MAX(notice_id), 0)+1, ?, ?, ?, ?, ?, ?, ?, ? FROM sn_notice";
        int rows = update(sql, new Object[] { notice.getUserId(), notice.getStockId(), notice.getTitle(), notice.getContent(),
                notice.getFlag(), notice.getEmailResult(), notice.getSmsResult(), notice.getCreateTime() });
        if (rows > 0) {
            result = true;
        }

        return result;
    }

    /**
     * 更新发送标记
     */
    public boolean updateFlag(Integer noticeId, short value) {
        boolean result = false;
        String sql = "UPDATE sn_notice SET flag=? WHERE notice_id=?";
        int rows = update(sql, new Object[] { value, noticeId });
        if (rows > 0) {
            result = true;
        }

        return result;
    }

    /**
     * 更新发送标记
     */
    public boolean updateFlag(List<SnNotice> list, short value) {
        boolean result = false;
        StringBuffer sb = new StringBuffer("0");
        if (null != list && list.size() > 0) {
            for (SnNotice nt : list) {
                sb.append(",").append(nt.getNoticeId());
            }
        }
        String sql = "UPDATE sn_notice SET flag=? WHERE notice_id IN (" + sb.toString() + ")";

        int rows = update(sql, new Object[] { value });
        if (rows > 0) {
            result = true;
        }

        return result;
    }

    /**
     * 更新邮件发送结果
     */
    public boolean updateEmailResult(Integer noticeId, boolean value) {
        boolean result = false;
        String sql = "UPDATE sn_notice SET email_result=? WHERE notice_id=?";
        int rows = update(sql, new Object[] { value, noticeId });
        if (rows > 0) {
            result = true;
        }

        return result;
    }

    /**
     * 更新短信发送结果
     */
    public boolean updateSmsResult(Integer noticeId, boolean value) {
        boolean result = false;
        String sql = "UPDATE sn_notice SET sms_result=? WHERE notice_id=?";
        int rows = update(sql, new Object[] { value, noticeId });
        if (rows > 0) {
            result = true;
        }

        return result;
    }

    /**
     * 获取所有未发送的通知
     */
    @SuppressWarnings("unchecked")
    public List<SnNotice> getNewNotice() {
        List<SnNotice> ret = null;
        String sql = "SELECT notice_id as noticeId, email, login as userName, title, content FROM sn_notice n, sn_user u WHERE n.flag=? AND n.user_id=u.user_id";
        ret = find(sql, new Object[] { Constants.NOTICE_FLAG_DEFAULT }, SnNotice.class);
        return ret;
    }
}
