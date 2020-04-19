package com.sy.hotel.cipher;

import com.sy.hotel.cipher.impl.AESCipher;
import com.sy.hotel.cipher.impl.RSACipher;

public class MyCipherTest {

    public static void main(String[] args) {
        AESCipher aesCipher= (AESCipher) MyCiphers.getMyCipher("aes");
        aesCipher.setKey(AESCipher.customGenerateKey("liyuxiangshidashuaige"));
        System.out.println(aesCipher.encodeString("liyuxiang951112@163.com"));
        System.out.println(aesCipher.encodeString("lianjiealiyun951112"));
        System.out.println(aesCipher.encodeString("root"));
        System.out.println(aesCipher.encodeString("root"));


        RSACipher rsaCipher= (RSACipher) MyCiphers.getMyCipher("rsa");
//        System.out.println(rsaCipher.encodeString("liyuxiang"));;
    }
}
