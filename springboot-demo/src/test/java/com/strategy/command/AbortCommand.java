package com.strategy.command;

import com.strategy.strategy.CommondStrategy;

public class AbortCommand implements CommondStrategy {
	@Override
	public void process(String message) {
		System.out.println("commomd type"+message);
	}
}
