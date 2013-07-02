package com.luyunfei.erp.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
	public static String md5Encrypt(String str){
		MessageDigest md5;
		String result=null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			result=new String(md5.digest(str.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
