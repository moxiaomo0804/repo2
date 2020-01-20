package com.thw.arithmetic;

import java.net.SocketTimeoutException;

public class Reverse {
	public static void main(String[] args) {
		String oldSentence = "I am a boy";
		reverseSentence(oldSentence);
		reverseSplit(oldSentence);
	}
	public static  void reverseSentence(String oldSentence){
		char[] chars = oldSentence.toCharArray();
		for (int i = chars.length-1; i >=0 ; i--) {
			System.out.print(chars[i]);
		}
		System.out.println();
	}
	public static void reverseSplit(String string){
		String[] strings = string.split(" ");
		for (int i = strings.length-1; i >= 0 ; i--) {
			System.out.print(strings[i]+" ");
		}
		System.out.println();
	}
}
