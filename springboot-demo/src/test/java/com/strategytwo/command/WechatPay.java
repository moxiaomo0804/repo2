package com.strategytwo.command;

import com.strategytwo.PayStrategy;

public class WechatPay implements PayStrategy {

    public void pay(double total) {
        System.out.println("pay with wechatpay: " + total*3);
    }

}