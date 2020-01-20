package com.lambda.data;

public class Person {
	public String name;
	public int age;

	public Person() {
		System.out.println("空参");
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("有参");
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Person{");
		sb.append("name='").append(name).append('\'');
		sb.append(", age=").append(age);
		sb.append('}');
		return sb.toString();
	}
}
