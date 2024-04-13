package bugreportapplication;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author David Liu, Longric Tran, Refath Ahmed, Tao Wang, Vito Carnovale (Group #33)
 *
 * Represents a SendEmailsTLS class for functions related to the email notification system
 */
public class SendEmailTLS {

    /**
     *
     * sends an email to a user
     *
     * @param email          the email address that the notification email will be sent to
     * @param subjectLine    the subject line for the email that is to be sent
     * @param emailMessage   the body of the email that is to be sent
     */
    public static void send(String email,String subjectLine,String emailMessage) {

        // account details for the account that sends the email
        final String username = "cps420group33@gmail.com";
        final String password = null;

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS


        // authenticate login for the account that sends the mail
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
        // try to send the email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("cps420group33@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject(subjectLine);
            message.setText(emailMessage);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
