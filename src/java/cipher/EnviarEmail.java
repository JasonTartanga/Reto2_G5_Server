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

public class EnviarEmail {

    public static void main(String[] args) {

        String contrasena = generarContrasena();

        // protocol properties
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", ResourceBundle.getBundle("claves").getString("ZOHO_HOST")); // change to GMAIL_HOST for gmail                                                         // for gmail
        props.setProperty("mail.smtp.port", ResourceBundle.getBundle("claves").getString("TLS_PORT"));
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtps.auth", "true");

        // close connection upon quit being sent
        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);

        try {
            // create the message
            final MimeMessage msg = new MimeMessage(session);

            // set recipients and content
            msg.setFrom(new InternetAddress(ResourceBundle.getBundle("claves").getString("SENDER_USERNAME")));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jasontartanga@gmail", false));
            msg.setSubject("Demo");
            msg.setText("Cortate el pelo", "utf-8", "html");
            msg.setSentDate(new Date());

            // send the mail
            Transport transport = session.getTransport("smtps");
            // send the mail
            transport.connect(ResourceBundle.getBundle("claves").getString("ZOHO_HOST"), ResourceBundle.getBundle("claves").getString("SENDER_USERNAME"), ResourceBundle.getBundle("claves").getString("SENDER_PASSWORD"));
            transport.sendMessage(msg, msg.getAllRecipients());

        } catch (MessagingException e) {
            throw new RuntimeException(e);

        }

    }

    public static String generarContrasena() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int longitudMaxima = 15;

        SecureRandom random = new SecureRandom();
        StringBuilder contrasenaBuilder = new StringBuilder();

        // Añadir al menos una mayúscula
        char mayuscula = caracteres.charAt(random.nextInt(26));
        contrasenaBuilder.append(mayuscula);

        // Añadir al menos un número
        char numero = caracteres.charAt(random.nextInt(10) + 52); // Los números comienzan en la posición 52
        contrasenaBuilder.append(numero);

        // Completar la contraseña con caracteres aleatorios
        for (int i = 2; i < longitudMaxima; i++) {
            char caracter = caracteres.charAt(random.nextInt(caracteres.length()));
            contrasenaBuilder.append(caracter);
        }

        return contrasenaBuilder.toString();
    }
}
