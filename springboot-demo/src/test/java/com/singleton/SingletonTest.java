package com.singleton;

import java.lang.invoke.VolatileCallSite;

public class SingletonTest {
	private SingletonTest() {};
	private static volatile SingletonTest singletonTest;

	public SingletonTest getSingletonTestInstance() {
		if (singletonTest == null) {
			synchronized (SingletonTest.class) {
				singletonTest = new SingletonTest();
			}
		}
		return singletonTest;
	}
}
