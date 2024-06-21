/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author TheOneAboveAll
 */
public class EncriptationPwd {
    
    public static String encrypt(String input){
        String output = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes());
            
            StringBuilder sb = new StringBuilder();
            
            for(byte d : digest){
                sb.append(String.format("%02x", d));
            
            }
            output = sb.toString();
                    
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncriptationPwd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return output;
    }
    
    public static String encode(String key, String cadena){
        String code = "";
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] keyPwd = md5.digest(key.getBytes("utf-8"));
            byte[] bytesKey = Arrays.copyOf(keyPwd, 24);
            
            SecretKey secretKey = new SecretKeySpec(bytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            
            cifrado.init(Cipher.ENCRYPT_MODE, secretKey); //creacion de la llave
            
            byte[] plainTextByte = cadena.getBytes("utf-8");
            byte[] buffer = cifrado.doFinal(plainTextByte);
            byte[] base64 = Base64.encodeBase64(buffer);
            
            code = new String(base64);
            
        }   catch (Exception e){    System.out.println("el erro es " + e);      }
        
        return code;
    }
    
    public static String decode(String keyS, String cadenaE){
        String code = "";
        
        try{
            byte[] mesage = Base64.decodeBase64(cadenaE.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            
            byte[] digestOfPwd = md5.digest(keyS.getBytes("utf-8"));
            byte[] keyByte = Arrays.copyOf(digestOfPwd, 24);
            
            SecretKey key = new SecretKeySpec(keyByte, "DESede");
            
            Cipher desipher = Cipher.getInstance("DESede");
            desipher.init(Cipher.DECRYPT_MODE, key);
              
            byte[] plainText = desipher.doFinal(mesage);
            
            code = new String(plainText, "UTF-8");
            
        
        } catch (Exception e){    System.out.println("el erro es " + e);      }
        
    
        return code;
    }
    
    
    public static void main(String[] args){
        String secretKey = "TacosConChelas";
    
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe lo que decees desencriptar"); 
        String palabra = sn.nextLine();
        
        /*
            0 Tacos22
            1 11
            1111    12345
            1112    12345
            2222    pepe
            2323    1111
            2324    perro
            3434    123452323
            4444    123456
            9999    tacochela22
            23232   3030
        
        
        */
       
        System.out.println("texto encriptado " + encode(secretKey, palabra));
        
    }
    
}
