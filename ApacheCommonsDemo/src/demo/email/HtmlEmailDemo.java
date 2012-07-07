package demo.email;

import java.net.URL;

import org.apache.commons.mail.HtmlEmail;

public class HtmlEmailDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setDebug(true);

            email.setHostName("smtp.gmail.com");
            email.setSSL(true);
            email.setSslSmtpPort("465");
            email.setAuthentication("from@gmail.com", "password");
            email.setFrom("from@gmail.com", "发件人", "UTF-8");
            email.addTo("to@163.com", "收件人");
            email.setSubject("HTML邮件测试");// 设置邮件的主题
            // embed the image and get the content id
            URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
            String cid = email.embed(url, "Apache图标");
            email.updateContentType("text/html; charset=UTF-8");
            // set the html message
            email.setHtmlMsg("<html>The apache logo(图标) - <img src=\"cid:" + cid + "\"></html>");

            // set the alternative message
            email.setTextMsg("Your email client does not support HTML messages");

            // send the email
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
