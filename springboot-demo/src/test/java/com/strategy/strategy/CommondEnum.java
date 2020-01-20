package com.strategy.strategy;

import java.util.HashMap;
import java.util.Map;

public enum CommondEnum {
	SELECT("select","com.strategy.command.SelectCommond"),
	ADD("add","com.strategy.command.AddCommand"),
	ABORT("abort","com.strategy.command.AbortCommand");
	private  String command;
	private  String clazz;

	public static Map<String,String> getAllClazz(){
		Map<String ,String> map = new HashMap<>(8);
		for (CommondEnum commandEnum : CommondEnum.values()) {
			map.put(commandEnum.getCommand(), commandEnum.getClazz());
		}
		return map;
	}
	CommondEnum(String command, String clazz) {
		this.command = command;
		this.clazz = clazz;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
}
