package com.designmode.bridge;

import com.designmode.bridge.impl.GreenPen;

public class BridgeTest {
	public static void main(String[] args) {
		DrawAPI drawAPI = new GreenPen();
		int radius = 10;
		Circle circle = new Circle(radius,drawAPI);
	}
}
