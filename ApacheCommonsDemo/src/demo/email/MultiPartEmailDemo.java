package demo.email;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class MultiPartEmailDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            // Create the attachment
            EmailAttachment attachment = new EmailAttachment();
            // 方式1:URL附件
            // attachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
            // 方式2:文件附件
            attachment.setPath("E:\\dwc.jpg");
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("长沙大碗菜");
            attachment.setName("dwc.jpg");

            MultiPartEmail email = new MultiPartEmail();
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setSSL(true);
            email.setSslSmtpPort("465");
            email.setAuthentication("from@gmail.com", "password");

            email.setFrom("from@gmail.com", "发件人", "UTF-8");
            email.addTo("to@163.com", "收件人");
            email.setSubject("带附件邮件测试");
            email.setMsg("邮件正文！");

            // add the attachment
            email.attach(attachment);

            // send the email
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
