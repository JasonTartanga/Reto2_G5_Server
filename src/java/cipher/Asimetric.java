package cipher;

import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;

/**
 * Clase para cofrado asimetrico
 *
 * @author Jason.
 */
public class Asimetric {

    private static final Logger LOG = Logger.getLogger(Asimetric.class.getName());

    /**
     * Metodo para descifrar la contraseña
     *
     * @param passwd es la contraseña que recoge cifrada para descifrarla
     * @return la contraseña descifrada
     */
    public static String decipherPasswd(String passwd) {
        FileInputStream fis = null;
        String decipherPasswd = null;

        try {
            // Cargamos la clave privada
            try {
                fis = new FileInputStream(System.getProperty("user.home") + File.separator + "Documents\\CashTracker\\privateKey.der");
            } catch (FileNotFoundException e) {
                fis = new FileInputStream("src/cipher/privateKey.der");
            }
            byte[] privateKeyBytes = new byte[fis.available()];
            fis.read(privateKeyBytes);
            fis.close();

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            // Desencriptamos la contraseña
            byte[] encryptedData = DatatypeConverter.parseHexBinary(passwd);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedData = cipher.doFinal(encryptedData);

            //La convierte en un String
            decipherPasswd = new String(decryptedData);

        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            LOG.severe(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                LOG.severe(e.getMessage());
            }
        }
        return decipherPasswd;
    }
}
