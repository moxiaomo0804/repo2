package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest2 {
	public static void main(String[] args) {
		Student s1 = new Student(1L, "肖战", 15, "浙江");
		Student s2 = new Student(2L, "王一博", 15, "湖北");
		Student s3 = new Student(3L, "杨紫", 17, "北京");
		Student s4 = new Student(4L, "李现", 17, "浙江");
		Student s5 = new Student(1L, "肖战", 15, "浙江");
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		List<Student> collect = students.stream().filter(s -> "浙江".equals(s.getAddress())).collect(Collectors.toList());
		//collect.forEach(System.out::println);
		List<String> collect1 = students.stream().map(s -> "地址：" + s.getAddress()).collect(Collectors.toList());
		collect1.forEach(System.out::println);

		List<String> list = Arrays.asList("111","222","333","111","222");
		//list.stream().distinct().forEach(System.out::println);

		//students.stream().distinct().forEach(System.out::println);

		List<String> list1 = Arrays.asList("333","222","111");
		//list1.stream().sorted().forEach(System.out::println);
		//limit（限制返回个数）
		//list1.stream().limit(2).forEach(System.out::println);
		//skip(删除元素)
		list1.stream().skip(2).forEach(System.out::println);
		//上面指定排序规则，先按照学生的id进行降序排序，再按照年龄进行降序排序
		students.stream().sorted((stu1,stu2)->Long.compare(stu2.getId(),stu1.getId()))
				.sorted((stu1,stu2)->Integer.compare(stu2.getAge(),stu1.getAge()))
				.forEach(System.out::println);
		/**
		 * 集合reduce,将集合中每个元素聚合成一条数据
		 */
		List<String> list2 = Arrays.asList("欢","迎","你");
		String appendStr = list2.stream().reduce("北京",(a,b) -> a+b);
		System.out.println(appendStr);
		/**
		 * 求集合中元素的最小值
		 */
		Student student = students.stream().min((stu1, stu2) -> Integer.compare(stu1.getAge(), stu2.getAge())).get();
		System.out.println(student);

		//anyMatch/allMatch/noneMatch（匹配）
		Boolean anyMatch = students.stream().anyMatch(s ->"湖北".equals(s.getAddress()));
		if (anyMatch) {
			System.out.println("有湖北人");
		}
		Boolean allMatch = students.stream().allMatch(s -> s.getAge()>=15);
		if (allMatch) {
			System.out.println("所有学生都满15周岁");
		}
		Boolean noneMatch = students.stream().noneMatch(s -> "杨洋".equals(s.getName()));
		if (noneMatch) {
			System.out.println("没有叫杨洋的同学");
		}
	}
}
