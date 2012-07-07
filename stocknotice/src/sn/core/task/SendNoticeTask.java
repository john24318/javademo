package sn.core.task;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sn.base.util.Constants;
import sn.base.util.DateUtil;
import sn.core.persistence.dao.SnNoticeDao;
import sn.core.persistence.dao.impl.SnNoticeDaoImpl;
import sn.core.persistence.model.SnNotice;
import sn.core.service.EmailService;
import sn.core.service.impl.EmailServiceImpl;

public class SendNoticeTask extends TimerTask {
    private static Log log = LogFactory.getLog(SendNoticeTask.class);
    private SnNoticeDao noticeDao = new SnNoticeDaoImpl();
    private final EmailService emailService = new EmailServiceImpl();

    @Override
    public void run() {
        log.debug("发送通知开始于：" + DateUtil.convertDateToString(new Date()));

        List<SnNotice> noticeList = noticeDao.getNewNotice();
        if (noticeList.size() > 0) {
            noticeDao.updateFlag(noticeList, Constants.NOTICE_FLAG_SENDED);

            for (SnNotice notice : noticeList) {
                new SendNoticeThread(emailService, noticeDao, notice).start();
            }
        }

        log.debug("发送通知完成于：" + DateUtil.convertDateToString(new Date()));
    }

}

class SendNoticeThread extends Thread {
    private static Log log = LogFactory.getLog(SendNoticeThread.class);
    private EmailService emailService = null;
    private SnNotice notice = null;
    private SnNoticeDao noticeDao = null;

    public SendNoticeThread(EmailService emailService, SnNoticeDao noticeDao, SnNotice notice) {
        super();
        this.emailService = emailService;
        this.noticeDao = noticeDao;
        this.notice = notice;
    }

    @Override
    public void run() {
        log.debug("发送邮件开始于：" + DateUtil.convertDateToString(new Date()));

        // 发送邮件
        boolean success = emailService.sendEmail(notice.getEmail(), notice.getUserName(), notice.getTitle(), notice.getContent());
        if (success) {
            // 将邮件发送结果置为“发送成功”状态
            noticeDao.updateEmailResult(notice.getNoticeId(), Constants.NOTICE_RESULT_SUCCESS);
        } else {
            // 将通知标记置为“未发送”状态，下次重新发送
            noticeDao.updateFlag(notice.getNoticeId(), Constants.NOTICE_FLAG_DEFAULT);
        }

        log.debug("发送邮件完成于：" + DateUtil.convertDateToString(new Date()));
    }
}