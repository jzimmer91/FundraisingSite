/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Joe
 */
public class PasswordEncrypt {
    
    public static String Encrypt(String password){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String passwd = password;
            md.update(passwd.getBytes("UTF-8"));
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            String output = DatatypeConverter.printHexBinary(MessageDigest.getInstance("SHA-256").digest(passwd.getBytes("UTF-8")));
            return output;
            
         } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordEncrypt.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
