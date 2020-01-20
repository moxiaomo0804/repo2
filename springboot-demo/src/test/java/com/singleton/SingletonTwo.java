package com.singleton;

public class SingletonTwo {
	private SingletonTwo(){};
	private static SingletonTwo instance;
	public static SingletonTwo getInstance(){
		if (instance == null) {
			instance = new SingletonTwo();
		}
		return instance;
	}
}
