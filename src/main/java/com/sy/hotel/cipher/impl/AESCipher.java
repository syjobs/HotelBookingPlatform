package com.sy.hotel.cipher.impl;

import com.sy.hotel.cipher.MyCipher;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author sunyang
 * @date 2019/12/1
 */
public class AESCipher implements MyCipher{
    private static final SecretKey DEFAULT_KEY=defaultGenerateKey();
    private SecretKey key=DEFAULT_KEY;

    //自定义AES密钥
    public static SecretKey customGenerateKey(String customKey){
        byte[] buffer= DigestUtils.md5(customKey);
        return new SecretKeySpec(buffer,"AES");
    }

    public void setKey(SecretKey key){
        this.key=key;
    }

    //随机生成默认的AES密钥
    private static SecretKey defaultGenerateKey() {
        try {
            KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String encodeString(String originalStr) {
        try {
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] buffer=cipher.doFinal(originalStr.getBytes());
            return Base64.getEncoder().encodeToString(buffer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String decodeString(String cipheredStr) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] buffer = Base64.getDecoder().decode(cipheredStr);
            buffer = cipher.doFinal(buffer);
            return new String(buffer, "utf-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
