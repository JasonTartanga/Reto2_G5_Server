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

/**
 * Clase para el envio de email
 *
 * @author Ian y Jessica.
 */
public class EnviarMail {

    /**
     * Metodo para enviar el email con las contraseñas
     *
     * @param MAIL_RECEPTOR es el receptos del email
     * @param MAIL_SUBJECT es el asunto del email
     * @param MESSAGE es el mensaje de correo
     *
     */
    public static void enviarEmail(String MAIL_RECEPTOR, String MAIL_SUBJECT, String MESSAGE) {

        final String ZOHO_HOST = "smtp.zoho.eu";
        final String TLS_PORT = "897"; //465

        String decipherCredentials = Simetric.descifrarTexto("Clave");

        String[] parts = decipherCredentials.split("/");

        String MAIL_EMISOR = parts[0];
        String MAIL_PASSWORD = parts[1];

        // protocol properties
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", ZOHO_HOST); // change to GMAIL_HOST for gmail for gmail
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
            msg.setText(MESSAGE, "utf-8", "html");
            msg.setSentDate(new Date());

            // send the mail
            Transport transport = session.getTransport("smtps");
            // send the mail
            transport.connect(ZOHO_HOST, MAIL_EMISOR, MAIL_PASSWORD);
            transport.sendMessage(msg, msg.getAllRecipients());

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }
        ;

    }

    /**
     * Metodo para generar una contraseña aleatoria con una longitud maxima de
     * 15 caracteres
     *
     * @return la contraseña en una variable que se utilizada en el metodo
     * anterior
     */
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
