package com.nov.virtual.shop.okEx.okcoin.rest;

public class StringUtil {

	public static boolean isEmpty(String str) {
		if(str == null) 
			return true; 
		String tempStr = str.trim(); 
		if(tempStr.length() == 0)
			return true; 
		if(tempStr.equals("null"))
			return true;
		return false; 
	}
}
