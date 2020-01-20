package com.strategy.strategy;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class CommandContext {
	public CommondStrategy getInstance(String commondType) {
		CommondStrategy commondStrategy = null;
		Map<String, String> allClazz = CommondEnum.getAllClazz();
		String clazz = allClazz.get(commondType.trim().toLowerCase());
		if (StringUtils.isNotEmpty(clazz)){
			try {
				commondStrategy = (CommondStrategy)Class.forName(clazz).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return commondStrategy;
	}
}
