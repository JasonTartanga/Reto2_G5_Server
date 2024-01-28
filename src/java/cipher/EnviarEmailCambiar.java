/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cipher;

import java.security.SecureRandom;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.ResourceBundle;

public class EnviarEmailCambiar {

    public static void enviarEmail(String email, String passDescifrada) {

        String clave = null;
        final String ZOHO_HOST = "smtp.zoho.eu";
        final String TLS_PORT = "897";
        String zoho = SimetricoDescifrar.descifrarTexto(clave);
        String[] partes = zoho.split("/");

        if (partes.length == 2) {
            String mail = partes[0];
            String passwd = partes[1];

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
                msg.setFrom(new InternetAddress(mail));
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
                msg.setSubject("Demo");
                msg.setText("Enhorabuena su contraseña ha sido cambiada a " + passDescifrada + "con exito", "utf-8", "html");
                msg.setSentDate(new Date());

                // send the mail
                Transport transport = session.getTransport("smtps");
                // send the mail
                transport.connect(ZOHO_HOST, mail, passwd);
                transport.sendMessage(msg, msg.getAllRecipients());

            } catch (MessagingException e) {
                throw new RuntimeException(e);

            }

        }

    }

}
