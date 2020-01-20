package com.lambda.syntax;

import com.lambda.data.Person;

public class Systax4 {
	public static void main(String[] args) {
		personCreate create = ()->new Person();
		//构造方法的引用
		personCreate create1 = Person::new;
		Person a = create.getPerson();
		Person b = create.getPerson();
		personCreate2 create2 = Person::new;
		Person c = create2.getPerson("tom", 22);
		System.out.println(c);
	}
}

interface personCreate{
	Person getPerson();
}

interface personCreate2{
	Person getPerson(String name,int age);
}