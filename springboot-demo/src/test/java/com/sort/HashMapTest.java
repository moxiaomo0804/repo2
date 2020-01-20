package com.sort;

import com.sun.org.apache.regexp.internal.RE;
import net.bytebuddy.implementation.bytecode.Throw;

import java.util.*;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<Integer, User> users = new HashMap<>();
		users.put(1, new User("张三", 25));
		users.put(3, new User("李四", 22));
		users.put(2, new User("王五", 28));

		System.out.println(users);

	}
	public static HashMap<Integer,User> sortHashMap(HashMap<Integer,User> map){
		Set<Map.Entry<Integer, User>> entries = map.entrySet();
		List<Map.Entry<Integer,User>> list = new ArrayList<>();
		return null;
		//return Optional.ofNullable(list).map(l->l.get(0)).orElse("UnKnow");
	}
}
