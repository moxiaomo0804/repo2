package com.gupaoedu.pub2019.chapter4;

import java.util.concurrent.TimeUnit;

public class InterrputDemo {
	private static int i;

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(()->{
			while (!Thread.currentThread().isInterrupted()) {
				i++;
			}
			System.out.println(i);
		},"interrputDemo");

		thread.start();
		TimeUnit.SECONDS.sleep(2);
		thread.interrupt();
	}
}
