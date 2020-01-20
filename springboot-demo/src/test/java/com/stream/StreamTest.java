package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String[] args) {
		List<String> stringList = new ArrayList<>();
		stringList.add("ddd2");
		stringList.add("aaa2");
		stringList.add("bbb1");
		stringList.add("aaa1");
		stringList.add("bbb3");
		stringList.add("ccc");
		stringList.add("bbb2");
		stringList.add("ddd1");
		stringList.stream().sorted().filter(s->s.startsWith("a")).forEach(System.out::println);
		//stringList.stream().map(String::toUpperCase).sorted((a,b)->a.compareTo(b)).forEach(System.out::println);
		System.out.println(stringList.stream().anyMatch((s) -> s.startsWith("a")));
		System.out.println(stringList.stream().allMatch(s -> s.startsWith("a")));
		System.out.println(stringList.stream().noneMatch(s -> s.startsWith("z")));
		System.out.println(stringList.stream().filter(s -> s.startsWith("b")).count());
		Optional<String> reduce = stringList.stream().sorted().reduce((s1, s2) -> s1 + "&" + s2);
		reduce.ifPresent(System.out::println);

		Integer [] myArray = { 1, 2, 3 };
		List myList = Arrays.stream(myArray).collect(Collectors.toList());
	}
}
