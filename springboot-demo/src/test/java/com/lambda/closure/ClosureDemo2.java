package com.lambda.closure;

import java.util.function.Consumer;

public class ClosureDemo2 {
	public static void main(String[] args) {
		//闭包中引用的变量一定是常量
		int a = 10;
		Consumer<Integer> c = ele->{
			System.out.println(ele);
		};
		c.accept(a);
	}
}
