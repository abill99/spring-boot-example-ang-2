package com.kinkode.ed.debug;

public class Debug {
	public static void out(String msg, Object obj) {
		System.out.print(msg + "  ");
		System.out.println(obj);
	}
	
	public static void out(Object obj) {
		out("",obj);
	}
	
	public static void out(String msg) {
		out("", msg);
	}

}
