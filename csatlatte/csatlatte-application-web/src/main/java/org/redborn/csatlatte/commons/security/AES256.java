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
import org.apache.tomcat.util.codec.binary.Base64;

public class AES256 {
	
	private byte[] keyData;
	private String iv;
	private String transformation;
	
	public AES256() {
		this("abcdefghijklmnopqrstuvwxyz123456");
	}
	
	public AES256(String key) {
		try {
			iv = key.substring(0, 16);
			keyData = key.getBytes(CharEncoding.UTF_8);
			transformation = "AES/CBC/PKCS5Padding";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public String encrypt(String str) {
		String result = null;
		try {
			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyData, "AES"), new IvParameterSpec(iv.getBytes(CharEncoding.UTF_8)));
			result = new String(Base64.encodeBase64(cipher.doFinal(str.getBytes(CharEncoding.UTF_8))), CharEncoding.UTF_8);
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
	
	public String decrypt(String str) {
		String result = null;
		try {
			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyData, "AES"), new IvParameterSpec(iv.getBytes(CharEncoding.UTF_8)));
			result = new String(cipher.doFinal(Base64.decodeBase64(str.getBytes(CharEncoding.UTF_8))), CharEncoding.UTF_8);
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
