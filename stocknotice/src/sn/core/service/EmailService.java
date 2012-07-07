package sn.core.service;

/**
 * 邮件服务
 * 
 * @author 王耀
 * 
 */
public interface EmailService {

    /**
     * 发送邮件
     * 
     * @param emailAddress收件人邮箱
     * @param userName收件人姓名
     * @param title邮件标题
     * @param content邮件内容
     * @return
     */
    public boolean sendEmail(String emailAddress, String userName, String title, String content);

    /**
     * 发送HTML邮件
     * 
     * @param emailAddress收件人邮箱
     * @param userName收件人姓名
     * @param title邮件标题
     * @param content邮件内容
     * @return
     */
    public boolean sendHtmlEmail(String emailAddress, String userName, String title, String content);
}
