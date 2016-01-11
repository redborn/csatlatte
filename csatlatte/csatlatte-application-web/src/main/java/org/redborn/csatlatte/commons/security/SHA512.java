package org.redborn.csatlatte.commons.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Base64;

/**
 * SHA512 암호화 처리를 합니다.
 * 
 * @author 최순열
 *
 */
public class SHA512 {
	
	/**
	 * 문자열을 암호화 합니다.
	 * 
	 * @param str 문자열
	 * @return 암호화 된 문자열
	 */
	public static String encrypt(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		messageDigest.update(str.getBytes());
		String result = null;
		try {
			result = new String(Base64.encodeBase64(messageDigest.digest()), CharEncoding.UTF_8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

}
