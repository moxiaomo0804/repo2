package com.JvmCas;

import java.util.concurrent.TimeUnit;

class MyData{
	volatile int number = 0;

	public void add() {
		this.number = 60;
	}
}
public class VolatileDemo {
	public static void main(String[] args) {
		MyData myData = new MyData();//资源类
		new Thread(()-> {
			System.out.println(Thread.currentThread().getName()+"\t come in");
			try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
			myData.add();
			System.out.println(Thread.currentThread().getName()+"\t update number:"+myData.number);
			},"aaa").start();
		while (myData.number == 0) {
			//main线程等待循环
		}
		System.out.println(Thread.currentThread().getName()+"\t mission is over,get number value: "+myData.number);
	}
}
