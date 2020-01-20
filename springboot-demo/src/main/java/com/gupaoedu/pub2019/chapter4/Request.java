package com.gupaoedu.pub2019.chapter4;

import java.util.StringJoiner;

public class Request {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Request.class.getSimpleName() + "[", "]")
				.add("name='" + name + "'")
				.toString();
	}
}
