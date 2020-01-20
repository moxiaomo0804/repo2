package com.lambda.exercise;

public class Exercise5 {
	public static void main(String[] args) {
		//开辟一条线程
		Thread t = new Thread(()->{
			for (int i = 0; i <10 ; i++) {
				System.out.println(i);
			}
		});
		new Thread(()-> System.out.println("lambda测试")).start();
		t.start();
	}
}
