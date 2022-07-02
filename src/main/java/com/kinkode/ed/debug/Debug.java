package com.kinkode.ed.debug;

public class Debug {
	public static void out(Object obj, String msg) {
		System.out.println(msg);
		System.out.println(obj);
	}
	
	public static void out(Object obj) {
		out(obj, "");
	}
	
	public static void out(String msg) {
		out("", msg);
	}

}
