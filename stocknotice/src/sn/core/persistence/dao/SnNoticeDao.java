package sn.core.persistence.dao;

import java.util.List;

import sn.base.persistence.dao.Dao;
import sn.core.persistence.model.SnNotice;

/**
 * 通知数据接口
 * 
 * @author 王耀
 * 
 */
public interface SnNoticeDao extends Dao {

    /**
     * 新增通知
     * 
     * @param notice
     * @return
     */
    public boolean add(SnNotice notice);

    /**
     * 更新发送标记
     * 
     * @param noticeId
     * @return
     */
    public boolean updateFlag(Integer noticeId, short value);

    /**
     * 更新发送标记
     */
    public boolean updateFlag(List<SnNotice> list, short value);

    /**
     * 更新邮件发送结果
     * 
     * @param noticeId
     * @param value
     * @return
     */
    public boolean updateEmailResult(Integer noticeId, boolean value);

    /**
     * 更新短信发送结果
     * 
     * @param noticeId
     * @param value
     * @return
     */
    public boolean updateSmsResult(Integer noticeId, boolean value);

    /**
     * 获取所有未发送的通知
     * 
     * @return
     */
    public List<SnNotice> getNewNotice();
}
