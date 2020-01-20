package com.thw.springbootdemo.web;

import com.alibaba.fastjson.JSONArray;
import org.apache.poi.util.StringUtil;

import java.math.BigDecimal;
import java.util.ArrayList;

public class NullPointTest {
	public static void main(String[] args) {
		String value=null;
		BigDecimal bigDecimal = new BigDecimal(value);
	}
}
