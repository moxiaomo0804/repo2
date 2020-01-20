package com.strategy.command;

import com.strategy.strategy.CommondStrategy;

public class AddCommand implements CommondStrategy {
	@Override
	public void process(String message) {
		System.out.println("commond type"+message);
	}
}
