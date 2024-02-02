/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cipher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase para realizar el hash de las contraseñas
 *
 * @author Ian y Jessica
 */
public class Hash {

    /**
     * Metodo para hashear las contraseñas a la base de datos
     *
     * @param text es utilizado para pasar la contraseña
     * @return null si entra en el catch
     */
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
