/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Chris
 */
public class Encriptacion {

    /**
     * Objeto SecureRandom utilizado para generar un vector de inicialización
     * aleatorio.
     */
    public static SecureRandom sr = new SecureRandom();

    /**
     * Método estático para encriptar una cadena de texto utilizando AES.
     *
     * @param value La cadena de texto a encriptar.
     * @return La cadena encriptada en formato base64.
     */
    public static String encriptar(String value) {
        String clave = "omaiga21omaiga21";
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            SecretKeySpec sks = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, sks, new IvParameterSpec(new byte[16]));

            byte[] encriptado = cipher.doFinal(value.getBytes());
            return DatatypeConverter.printBase64Binary(encriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Método estático para desencriptar una cadena de texto en formato base64
     * utilizando AES.
     *
     * @param encriptado La cadena encriptada en formato base64.
     * @return La cadena desencriptada.
     */
    public static String decriptar(String encriptado) {
        String clave = "omaiga21omaiga21";
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            SecretKeySpec sks = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
            cipher.init(Cipher.DECRYPT_MODE, sks, new IvParameterSpec(new byte[16]));

            byte[] dec = cipher.doFinal(DatatypeConverter.parseBase64Binary(encriptado));
            return new String(dec);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
