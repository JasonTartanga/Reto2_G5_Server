package cipher;

/**
 *
 * @author Jason.
 */
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.util.Base64;
import javax.xml.bind.DatatypeConverter;

public class Asimetric {

    private static final Logger log = Logger.getLogger(Asimetric.class.getName());

    public static String decipherPasswd(String passwd) {
        FileInputStream fis = null;
        String decipherPasswd = null;

        log.info("Contraseña cifrada --> " + passwd);

        try {
            // Cargamos la clave privada
            fis = new FileInputStream(System.getProperty("user.home") + File.separator + "Documents\\CashTracker\\privateKey.der");
            byte[] privateKeyBytes = new byte[fis.available()];
            fis.read(privateKeyBytes);
            fis.close();

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            // Desencriptamos la contraseña
            byte[] encryptedData = DatatypeConverter.parseHexBinary(passwd);

            System.out.println("Encripted data --> " + encryptedData);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedData = cipher.doFinal(encryptedData);

            //La convierte en un String
            decipherPasswd = new String(decryptedData);
            log.info("Contraseña descifrada --> " + decipherPasswd);

        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            // log.severe(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                // log.severe(e.getMessage());
                e.printStackTrace();
            }
        }
        return decipherPasswd;
    }

    private static byte[] convertMD5StringToByteArray(String md5HashString) {
        try {
            BigInteger bigInt = new BigInteger(md5HashString, 16);
            byte[] md5ByteArray = bigInt.toByteArray();

            // Asegurarse de que el array tenga 16 bytes (longitud esperada para un MD5 Hash)
            if (md5ByteArray.length < 16) {
                byte[] paddedArray = new byte[16];
                System.arraycopy(md5ByteArray, 0, paddedArray, 16 - md5ByteArray.length, md5ByteArray.length);
                md5ByteArray = paddedArray;
            }

            return md5ByteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String byteArrayToHexString(byte[] byteArray) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : byteArray) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
