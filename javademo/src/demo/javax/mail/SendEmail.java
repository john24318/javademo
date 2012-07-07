package demo.javax.mail;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    public static void send(String smtpHost, String smtpPort, final String user, final String password, String from, String to,
            String subject, String content) throws AddressException, MessagingException {
        // Create a mail session
        java.util.Properties props = new java.util.Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true"); // 必须为字符串类型，否则报错！！！
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        };
        Session session = Session.getDefaultInstance(props, authenticator);

        // Construct the message
        MimeMessage msg = new MimeMessage(session);
        msg.setSubject(subject, "UTF-8");
        msg.setText(content, "UTF-8");
        msg.setFrom(new InternetAddress(from));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

        // Send the message
        Transport.send(msg);
    }

    public static void main(String[] args) throws Exception {
        // Send a test message
        send("smtp.foxmail.com", "25", "accout", "password", "from@foxmail.com", "to@gmail.com", "邮件标题", "邮件正文");
    }
}
