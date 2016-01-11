package org.redborn.csatlatte.commons.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Base64;

public class SHA512 {
	
	public String encrypt(String str) {
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
