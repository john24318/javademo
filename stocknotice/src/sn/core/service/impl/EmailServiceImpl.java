package sn.core.service.impl;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

import sn.base.util.Constants;
import sn.base.util.FileUtils;
import sn.core.service.EmailService;

/**
 * 邮件服务实现类
 * 
 * @author 王耀
 * 
 */
public class EmailServiceImpl implements EmailService {

    private static Log log = LogFactory.getLog(EmailServiceImpl.class);
    private static Properties configProperties = FileUtils.loadPropertyFile(Constants.CONFIG_FILE);

    public boolean sendEmail(String emailAddress, String userName, String title, String content) {
        boolean result = false;
        Email email = new SimpleEmail();

        try {
            email.setHostName(configProperties.getProperty("mail.smtp.host"));
            email.setSSL("true".equalsIgnoreCase(configProperties.getProperty("mail.ssl")));
            email.setSslSmtpPort(configProperties.getProperty("mail.smtp.port"));
            email.setAuthentication(configProperties.getProperty("mail.user"), configProperties.getProperty("mail.password"));
            email.setFrom(configProperties.getProperty("mail.user"), configProperties.getProperty("mail.userName"), "UTF-8");

            email.addTo(emailAddress, userName, "UTF-8");
            email.setSubject(title);
            email.setMsg(content);
            email.updateContentType("text/plain; charset=UTF-8"); // 设置邮件内容类型

            email.send();
            result = true;
        } catch (EmailException e) {
            log.error(e.getMessage());
        }

        return result;
    }

    public boolean sendHtmlEmail(String emailAddress, String userName, String title, String content) {
        boolean result = false;
        HtmlEmail email = new HtmlEmail();

        try {
            email.setHostName(configProperties.getProperty("mail.smtp.host"));
            email.setSSL("true".equalsIgnoreCase(configProperties.getProperty("mail.ssl")));
            email.setSslSmtpPort(configProperties.getProperty("mail.smtp.port"));
            email.setAuthentication(configProperties.getProperty("mail.user"), configProperties.getProperty("mail.password"));
            email.setFrom(configProperties.getProperty("mail.user"), configProperties.getProperty("mail.userName"), "UTF-8");

            email.addTo(emailAddress, userName, "UTF-8");
            email.setSubject(title);
            email.setHtmlMsg(content);
            email.updateContentType("text/html; charset=UTF-8");// 设置邮件内容类型

            email.send();
            result = true;
        } catch (EmailException e) {
            log.error(e.getMessage());
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("start\t" + System.currentTimeMillis());
        EmailServiceImpl emailService = new EmailServiceImpl();
        System.out.println("init\t" + System.currentTimeMillis());

        String emailAddress = "wangyao1981@gmail.com";
        String userName = "王耀";
        boolean result = false;
        // String title = "股价通知测试";
        // String content = "股票价格大于您设定的最大价格！";
        // result = emailService.sendEmail(emailAddress, userName, title, content);
        String title = "HTML邮件";
        String content = "<html>HTML内容：<br><a href=\"www.baidu.com\">baidu</a></html>";
        result = emailService.sendHtmlEmail(emailAddress, userName, title, content);
        System.out.println("end\t" + System.currentTimeMillis());
        System.out.println("result\t" + result);
    }

}
