package org.redborn.csatlatte.commons.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Base64;

/**
 * AES256 암/복호화 처리를 합니다.
 * 
 * @author 최순열
 *
 */
public class AES256 {
	
	private static String TRANSFORMATION = "AES/CBC/PKCS5Padding";
	private static String KEY = "abcdefghijklmnopqrstuvwxyz123456";
	
	/**
	 * 문자열을 암호화 합니다.
	 * 
	 * @param str 문자열
	 * @return 암호화 된 문자열
	 */
	public static String encrypt(String str) {
		return encrypt(str, KEY);
	}
	
	/**
	 * 문자열을 암호화 합니다.
	 * 
	 * @param str 문자열
	 * @param key 키
	 * @return 암호화 된 문자열
	 */
	public static String encrypt(String str, String key) {
		String result = null;
		try {
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(CharEncoding.UTF_8), "AES"), new IvParameterSpec(key.substring(0, 16).getBytes(CharEncoding.UTF_8)));
			result = Base64.encodeBase64String(cipher.doFinal(str.getBytes(CharEncoding.UTF_8)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 문자열을 복호화 합니다.
	 * 
	 * @param str 암호화 된 문자열
	 * @return 복호화 된 문자열
	 */
	public static String decrypt(String str) {
		return decrypt(str, KEY);
	}
	
	/**
	 * 문자열을 복호화 합니다.
	 * 
	 * @param str 암호화 된 무낮열
	 * @param key 키
	 * @return 복호화 된 문자열
	 */
	public static String decrypt(String str, String key) {
		String result = null;
		try {
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(CharEncoding.UTF_8), "AES"), new IvParameterSpec(key.substring(0, 16).getBytes(CharEncoding.UTF_8)));
			result = new String(cipher.doFinal(Base64.decodeBase64(str)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return result;
	}

}
