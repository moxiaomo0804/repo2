package com.lambda.exercise;

import com.lambda.data.Person;

import java.util.TreeSet;

public class Exercise2 {
	public static void main(String[] args) {
		//TreeSet
		//使用lambda表达式实现Comparator接口，并实例化一个Treeset对象
		TreeSet<Person> set = new TreeSet<>((o1,o2)->{
			if (o1.age > o2.age) {
				return 1;
			}else {
				return -1;
			}
		});
		set.add(new Person("xioaming",21));
		set.add(new Person("hanmeimei",8));
		set.add(new Person("maomao",21));
		set.add(new Person("dada",31));
		System.out.println(set);
	}
}
