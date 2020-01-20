package com.thw.ceshi;

import org.assertj.core.util.Lists;

import java.util.ArrayList;

public class test {
	public static void main(String[] args) {
		 new Thread(()-> System.out.println("测试")).start();
		ArrayList<Object> objects = Lists.newArrayList();
		System.out.println(objects);
	}
}
