package demo.email;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class SimpleEmailDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Email email = new SimpleEmail();
            email.setDebug(true);

            email.setHostName("smtp.gmail.com");
            email.setSSL(true);
            email.setSslSmtpPort("465");
            email.setAuthentication("from@gmail.com", "password");

            email.setFrom("from@gmail.com", "发件人", "UTF-8");
            email.addTo("to@163.com", "收件人");
            email.setSubject("邮件测试1");
            email.setMsg("邮件正文！");
            email.updateContentType("text/plain; charset=UTF-8"); // 设置邮件内容类型
            // email.setContent("邮件正文！", "text/plain; charset=UTF-8");// 邮件正文消息
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
