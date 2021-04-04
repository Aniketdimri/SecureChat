package com.aniketdimri.securechat;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

public class Aes {
    private String messages;
    private byte encryptionKey[]={5,115,51,86,105,4,-31,-23,-68,88,17,20,3,-105,119,-53};
    private Cipher cipher,decipher;
    private SecretKeySpec secretKeySpec;

    public  String AESEncryption(String data) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        if(data==null){
            return null;
        }
        byte[] stringByte=data.getBytes();
        byte[] encryptedByte=new byte[stringByte.length];
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
        encryptedByte = cipher.doFinal(stringByte);
        String encryptedString = new String(encryptedByte,"ISO-8859-1");

        return encryptedString;
    }

    public String AESDecryption(String data) throws UnsupportedEncodingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if(data==null){
            return null;
        }
        byte[] encryptedByte = data.getBytes("ISO-8859-1");
        String decryptedString = data;
        byte[] decryption;
        decipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
        decryption = decipher.doFinal(encryptedByte);
        decryptedString = new String(decryption);
        return decryptedString;
    }
}
