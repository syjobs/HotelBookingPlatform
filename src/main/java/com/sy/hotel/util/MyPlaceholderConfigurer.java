package com.sy.hotel.util;

import com.sy.hotel.cipher.MyCiphers;
import com.sy.hotel.cipher.impl.AESCipher;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author sunyang
 * 解析jdbc配置文件
 */
public class MyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	private AESCipher cipher;
	
	public MyPlaceholderConfigurer() {
		cipher = (AESCipher) MyCiphers.getMyCipher("aes");
		cipher.setKey(AESCipher.customGenerateKey("liyuxiangshidashuaige"));
	}
	
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (propertyName.equals("jdbc_user") || propertyName.equals("jdbc_password")) {
			return cipher.decodeString(propertyValue);
		} else {
			return propertyValue;
		}
	}

}
