package com.JVM;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OOMTEST1 {
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		int i = 0;
		while (true) {
			list.add(new User(i++, UUID.randomUUID().toString()));
		}
	}
}
