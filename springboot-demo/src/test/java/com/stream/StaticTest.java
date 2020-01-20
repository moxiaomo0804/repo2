package com.stream;
public class StaticTest {
	public static void main(String[] args) {
		int i1 = 0x2f;
		System.out.println(Integer.toBinaryString(i1));

		for (int i = 1, j = i + 10; i < 5; i++, j = i * 2) {
			System.out.println("i="+i+"j="+j);
		}
	}
}
