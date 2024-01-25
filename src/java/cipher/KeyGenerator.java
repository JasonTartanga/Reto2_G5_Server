package cipher;

/**
 *
 * @author Jason.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.util.logging.Logger;

public class KeyGenerator {

    private static String rutaCashTracker = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "CashTracker" + File.separator;

    public static void main(String[] args) {
        try {
            //Especifico el tipo de clave que quiero generar
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            //Creo una carpeta llamada CashTracker
            File carpeta = new File(System.getProperty("user.home") + File.separator + "Documents\\CashTracker");
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            //Creo la clave publica
            PublicKey publicKeyAndMore = keyPair.getPublic();
            byte[] publicKeyBytes = publicKeyAndMore.getEncoded();
            try (FileOutputStream publicKeyFile = new FileOutputStream(rutaCashTracker + "publicKey.der")) {
                publicKeyFile.write(publicKeyBytes);
            }

            //Creo la clave privada
            PrivateKey privateKey = keyPair.getPrivate();
            byte[] privateKeyBytes = privateKey.getEncoded();
            try (FileOutputStream privateKeyFile = new FileOutputStream(rutaCashTracker + "privateKey.der")) {
                privateKeyFile.write(privateKeyBytes);
            }

            System.out.println("Ficheros de Clave Generados!");
        } catch (IOException | NoSuchAlgorithmException e) {
            Logger.getLogger(KeyGenerator.class.getName()).severe(e.getLocalizedMessage());
        }
    }
}
