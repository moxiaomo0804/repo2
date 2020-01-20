package com.lambda.syntax;

import com.lambda.lambdainterface.*;

import javax.sound.midi.Soundbank;

public class Syntax1 {
	public static void main(String[] args) {
		//lambda表达式的基础语法
		//lambda是一个匿名函数
		//参数列表 方法体
		//() : 用来描述参数列表 {}:描述方法体
		//->运算符读作gose to
		//无参 无返回
		NoReturnNoParameter lambda1 = ()->{
			System.out.println("hello world!");
		};
		lambda1.test();
		NoReturnOneParameter lambda2 = (int a)->{
			System.out.println(a);
		};
		lambda2.test(10);
		NoReturnTwoParameter lambda3 = (int a,int b)->{
			System.out.println(a+b);
		};
		lambda3.test(10,20);
		ReturnNoParameter lambda4 = ()->{
			System.out.println("lambda4");
			return 10;
		};
		int test4 = lambda4.test();
		System.out.println(test4);
		ReturnOneParameter lambda5 = (int a)->{
			System.out.println("lambda5");
			return a*2;
		};
		int test5 = lambda5.test(10);
		System.out.println(test5);
		ReturnTwoParameter lambda6 = (int a,int b)->{
			return a+b;
		};
		int test6 = lambda6.test(11, 12);
		System.out.println(test6);
	}
}
