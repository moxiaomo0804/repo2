package com.singleton;

public class SingletonFive {
	private SingletonFive(){};
	//volatile关键字能够禁止指令重排，保证在写操作没有完成之前不能调用读操作。
	private static volatile SingletonFive instance;

	public static SingletonFive getInstance() {
		if (instance == null) {
			synchronized (SingletonFive.class) {
				instance = new SingletonFive();
			}
		}
		return instance;
	}
}
