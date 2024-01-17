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

    public static void main(String[] args) {
        try {
            //Especifico el tipo de clave que quiero generar
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            //Descubre la ruta de documentos
            String rutaDocs = System.getProperty("user.home") + File.separator + "Documents";

            //Creo una carpeta llamada CashTracker
            File nuevoArchivo = new File(rutaDocs, "CashTracker");
            if (!nuevoArchivo.getParentFile().exists()) {
                nuevoArchivo.getParentFile().mkdirs();
            }

            //Creo la clave publica
            PublicKey publicKeyAndMore = keyPair.getPublic();
            byte[] publicKeyBytes = publicKeyAndMore.getEncoded();
            try (FileOutputStream publicKeyFile = new FileOutputStream(rutaDocs + "\\CashTracker\\publicKey.der")) {
                publicKeyFile.write(publicKeyBytes);
            }

            //Creo la clave privada
            PrivateKey privateKey = keyPair.getPrivate();
            byte[] privateKeyBytes = privateKey.getEncoded();
            try (FileOutputStream privateKeyFile = new FileOutputStream(rutaDocs + "\\CashTracker\\privateKey.der")) {
                privateKeyFile.write(privateKeyBytes);
            }

            System.out.println("Ficheros de Clave Generados!");
        } catch (IOException | NoSuchAlgorithmException e) {
            Logger.getLogger(KeyGenerator.class.getName()).severe(e.getLocalizedMessage());
        }
    }
}
