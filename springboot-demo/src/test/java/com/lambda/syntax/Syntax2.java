package com.lambda.syntax;

import com.lambda.lambdainterface.NoReturnOneParameter;
import com.lambda.lambdainterface.NoReturnTwoParameter;
import com.lambda.lambdainterface.ReturnNoParameter;
import com.lambda.lambdainterface.ReturnTwoParameter;

public class Syntax2 {
	public static void main(String[] args) {
		//由于在参数中已经定义了参数的类型和数量
		NoReturnTwoParameter lambda1 = (a, b) -> System.out.println(a + b);
		lambda1.test(2,3);
		NoReturnOneParameter lambda2 = a -> System.out.println(a);
		lambda2.test(44);
		ReturnNoParameter lambda3 = () -> 22;
		System.out.println(lambda3.test());
		ReturnTwoParameter lambda4 = (a,b)-> a+b;
		int test1 = lambda4.test(12, 14);
		System.out.println(test1);
	}
}
