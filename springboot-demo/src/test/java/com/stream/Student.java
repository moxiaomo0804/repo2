package com.stream;

import java.util.Objects;
import java.util.StringJoiner;

public class Student {
	private Long id;
	private String name;
	private Integer age;
	private String address;

	public Student(Long id, String name, Integer age, String address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("name='" + name + "'")
				.add("age=" + age)
				.add("address='" + address + "'")
				.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return id.equals(student.id) &&
				name.equals(student.name) &&
				age.equals(student.age) &&
				address.equals(student.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, age, address);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
