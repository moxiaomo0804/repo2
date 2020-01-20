package com.timeTest;

public class Singlton {
	private static Singlton instance = null;

	private Singlton() { };

	public static Singlton getInstance() {
		if (instance == null) {
			synchronized (Singlton.class) {
				instance = new Singlton();
			}
		}
		return instance;
	}
}
