package com.designmode.adapter;

public class AdapterTest {
	public static void main(String[] args) {
		// 有一只野鸡
		Cock wildCock = new WildCock();
		// 成功将野鸡适配成鸭
		Duck duck = new CockAdapter(wildCock);
		duck.fly();
		duck.quack();
	}
}
