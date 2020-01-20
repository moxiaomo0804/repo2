package com.strategytwo;

public class Client {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
		String payStrategyParam = "ALIPAY";
		PayStrategy strategy = StrategyFactory.getStrategy(payStrategyParam);
		strategy.pay(12);

		payStrategyParam = "WECHATPAY";//Param from front end

		strategy = StrategyFactory.getStrategy(payStrategyParam);
		strategy.pay(12);

		payStrategyParam = "EBANKPAY";//Param from front end

		strategy = StrategyFactory.getStrategy(payStrategyParam);
		strategy.pay(12);
	}
}
