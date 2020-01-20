package com.lambda.exercise;

import com.lambda.data.Person;

import java.util.ArrayList;
import java.util.Comparator;

public class Exercise1 {
	public static void main(String[] args) {
		//把Person按年龄降序
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("xioaming",11));
		list.add(new Person("hanmeimei",8));
		list.add(new Person("maomao",21));
		list.add(new Person("dada",31));
		list.sort((o1,o2)-> o1.age-o2.age);
		System.out.println(list);
	}
}
