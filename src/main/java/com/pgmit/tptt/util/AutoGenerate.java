package com.pgmit.tptt.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoGenerate {

	public String generatePassword(int length) {
		
		String rawPwd = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String password = RandomStringUtils.random(length, rawPwd);
		
		return password;
	}
	
	public String encodePassword(String password) {
		Base64 b =new Base64();
		String encodedPwd = b.encodeAsString(password.getBytes());
		return encodedPwd;
	}
}
