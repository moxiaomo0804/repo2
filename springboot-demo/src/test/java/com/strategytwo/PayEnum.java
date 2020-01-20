package com.strategytwo;

public enum PayEnum {
	ALIPAY("com.strategytwo.command.Alipay"),
	WECHATPAY("com.strategytwo.command.WechatPay"),
	EBANKPAY("com.strategytwo.command.EbankPay");
	private final String className;

	public String getClassName() {
		return className;
	}

	PayEnum(String className) {
		this.className = className;
	}
}
