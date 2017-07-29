/**
 * <p>Title: MD5.java</p>
 * <p>MD5</p>
 * @author damon
 * @date 2015年3月24日
 * @version 1.0
 */
package com.wx.middleware.server.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>Title: MD5</p>
 * <p>MD5</p> 
 * @author damon
 * @date 2015年3月24日
 */
public class MD5 {
	
	public static String Md532(String plainText) throws NoSuchAlgorithmException { 
		MessageDigest md = MessageDigest.getInstance("MD5"); 
		md.update(plainText.getBytes()); 
		byte b[] = md.digest(); 
		int i; 
		StringBuffer buf = new StringBuffer(""); 
		for (int offset = 0; offset < b.length; offset++) { 
			i = b[offset]; 
			if(i<0) i+= 256; 
			if(i<16) 
			buf.append("0"); 
			buf.append(Integer.toHexString(i)); 
		}
		return buf.toString();
	} 
	
	public static String Md516(String plainText) throws NoSuchAlgorithmException { 
		return Md532(plainText).substring(8,24);
	} 
	
}

