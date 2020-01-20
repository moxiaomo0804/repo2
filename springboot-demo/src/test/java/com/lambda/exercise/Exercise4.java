package com.lambda.exercise;

import com.lambda.data.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Exercise4 {
	public static void main(String[] args) {
		//删除集合中满足条件的元素
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("xioaming",11));
		list.add(new Person("hanmeimei",8));
		list.add(new Person("maomao",21));
		list.add(new Person("dada",31));
		//删除年龄大于十岁的元素
		ListIterator<Person> it = list.listIterator();
		/*while (it.hasNext()) {
			Person ele = it.next();
			if (ele.age > 10) {
				it.remove();
			}
		}*/
		//将集合中每一个元素都带入test方法中如果为true则移除
		list.removeIf(ele -> ele.age > 10);
		System.out.println(list);
	}
}
