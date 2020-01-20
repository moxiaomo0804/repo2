package com.lambda.syntax;

import com.lambda.lambdainterface.ReturnOneParameter;

public class Syntax3 {
	public static void main(String[] args) {
		//方法引用
		//可以快速的将一个lambda表达式的实现指向一具已经实现的方法
		//语法 方法的隶属者::方法名
		//注意
		//1、参数数量和类型一定要和接口中定义的方法一致
		//2、返回值的类型也要和接口中定义的类型一致
		ReturnOneParameter lambda = a -> change(a);

		ReturnOneParameter lambda2 = Syntax3::change;

		int test = lambda.test(10);
		System.out.println(test);
		ReturnOneParameter lambda1 = a -> a*2;

	}
	private static int change(int a){
		return a*2;
	}
}
