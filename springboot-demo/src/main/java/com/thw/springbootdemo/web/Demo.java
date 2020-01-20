package com.thw.springbootdemo.web;

import org.apache.poi.util.StringUtil;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
	public static void main(String[] args) {

		Map<String, Long> payedUserMap = new HashMap<String, Long>();

		payedUserMap.put("张飞", 1576566901000L);
		payedUserMap.put("关羽", 1576566901001L);
		payedUserMap.put("刘备", 1576566901002L);
		payedUserMap.put("诸葛", 1576566901003L);



		Map<String, Long> sortedByCount = payedUserMap.entrySet()
				.stream()
				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(sortedByCount);
	}
	}
