package com.java8date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);

		// 解析字符串to时间
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime time = LocalDateTime.now();
		String localTime = df.format(time);
		LocalDateTime ldt4 = LocalDateTime.parse("2017-09-28 17:07:05",df);
		System.out.println("LocalDateTime转成String类型的时间："+localTime);
		System.out.println("String类型的时间转成LocalDateTime："+ldt4);
		int count = 10 >> 1;
		System.out.println(count);
	}
}
