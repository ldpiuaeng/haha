package com.util.tools;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Base64Code {
	

	/**
	 * 编码
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encode(String str) {
		byte[] bytes;
		bytes = (new Base64()).encode(str.getBytes());
		return new String(bytes);
	}

	/**
	 * 解码
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decode(String str) {
		byte[] bytes;
		bytes = (new Base64()).decode(str.getBytes());
		return new String(bytes);
	}
}
