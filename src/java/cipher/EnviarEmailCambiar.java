package cipher;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public class EnviarEmailCambiar {

    public static void enviarEmail(String MAIL_RECEPTOR, String passDescifrada) {

        final String ZOHO_HOST = "smtp.zoho.eu";
        final String TLS_PORT = "897";
        final String MAIL_SUBJECT = "Cambio de contraseña";

        String decipherCredentials = Simetric.descifrarTexto("Clave");

        String[] parts = decipherCredentials.split("/");

        String MAIL_EMISOR = parts[0];
        String MAIL_PASSWORD = parts[1];

        System.out.println("Mail --> " + MAIL_EMISOR);
        System.out.println("Passwd --> " + MAIL_PASSWORD);

        // protocol properties
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", ZOHO_HOST); // change to GMAIL_HOST for gmail
        props.setProperty("mail.smtp.port", TLS_PORT);
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtps.auth", "true");

        // close connection upon quit being sent
        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);

        try {
            // create the message
            final MimeMessage msg = new MimeMessage(session);

            // set recipients and content
            msg.setFrom(new InternetAddress(MAIL_EMISOR));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(MAIL_RECEPTOR, false));
            msg.setSubject(MAIL_SUBJECT);
            msg.setText("Enhorabuena su contraseÃ±a ha sido cambiada a " + passDescifrada + "con exito", "utf-8", "html");
            msg.setSentDate(new Date());

            // send the mail
            Transport transport = session.getTransport("smtps");
            // send the mail
            transport.connect(ZOHO_HOST, MAIL_EMISOR, MAIL_PASSWORD);
            transport.sendMessage(msg, msg.getAllRecipients());

        } catch (MessagingException e) {
            throw new RuntimeException(e);

        }
    }
}
