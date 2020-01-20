package com.singleton;

/**
 * 解决了写法二可能出现的问题，可以在多线程中使用。
 * 缺点在于synchronized关键字会强制一次只能让一个线程进入方法中，
 * 其他线程不得不阻塞等待该线程退出方法。
 */
public class SingletonThree {
	private SingletonThree(){};
	private static SingletonThree instance;

	public synchronized static SingletonThree getInstance() {
		if (instance == null) {
			instance = new SingletonThree();
		}
		return instance;
	}
}
