package cipher;

/**
 *
 * @author Jason.
 */
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Asimetric {

    public static String decipherPasswd(String passwd) {
        FileInputStream fis = null;
        String decipherPasswd = null;

        try {
            byte[] privateKeyBytes;
            // Load Public Key
            fis = new FileInputStream(System.getProperty("user.home") + File.separator + "Documents\\CashTracker\\privateKey.der");
            privateKeyBytes = new byte[fis.available()];
            fis.read(privateKeyBytes);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            byte[] encryptedData = passwd.getBytes(StandardCharsets.UTF_8);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedData = cipher.doFinal(encryptedData);

            decipherPasswd = Base64.getEncoder().encodeToString(decryptedData);

        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            Logger.getLogger(Asimetric.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Asimetric.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return decipherPasswd;
    }
}
