/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cipher;

/**
 *
 * @author ian,Jessica
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    public static String hashText(String text) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md5.digest(text.getBytes());

            // Convierte el array de bytes a hexadecimal
            StringBuilder hexStringBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = String.format("%02X", b);
                hexStringBuilder.append(hex);
            }

            return hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
