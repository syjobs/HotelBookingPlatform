package com.yang.hrms.cipher;

import com.yang.hrms.cipher.impl.AESCipher;
import com.yang.hrms.cipher.impl.RSACipher;

public final class MyCiphers {

    private MyCiphers(){
        throw new AssertionError();
    }

    public static MyCipher getMyCipher(String algorithm) {
        algorithm = algorithm.toLowerCase();
        MyCipher myCipher = null;
        switch (algorithm) {
            case "aes":
                myCipher = new AESCipher();
                break;
            case "rsa":
                myCipher = new RSACipher();
                break;
            default:
                throw new RuntimeException("不支持该类型密钥");
        }
        return myCipher;
    }
}
