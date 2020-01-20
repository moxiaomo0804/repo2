package com.strategytwo;

import com.strategyone.Strategy;

public class StrategyFactory {
	public static PayStrategy getStrategy(String strategyType) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		String className = PayEnum.valueOf(strategyType).getClassName();
		return (PayStrategy) Class.forName(className).newInstance();
	}
}
