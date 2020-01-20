package com.thw.springbootdemo.web;

import java.util.ArrayList;
import java.util.List;

public class TestOOM {
	public static void fillHeap(int num) throws InterruptedException {
		List<OOMObject> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		System.gc();
	}

	public static void main(String[] args) throws InterruptedException {
		fillHeap(1000);
	}
}
