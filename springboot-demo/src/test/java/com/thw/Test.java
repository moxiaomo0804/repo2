package com.thw;

public class Test {
	public static void main(String[] args) {
		System.out.println(f1());
	}

	public static String f1(){
		String str = "hello";
		try {
			return str;
		}finally {
			str = "gupao";
		}
	}
}
