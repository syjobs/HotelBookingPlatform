package com.yang.hrms.cipher;

/**
 * @author sunyang
 * @date 2019/12/1
 */
public interface MyCipher {

    /**
     * 加密
     * @param originalStr 明文
     * @return 密文
     */
    public String encodeString(String originalStr);

    /**
     * 解密
     * @param cipheredStr
     * @return
     */
    public String decodeString(String cipheredStr);
}
