package com.strategytwo.command;

import com.strategytwo.PayStrategy;

public class Alipay implements PayStrategy {

    public void pay(double total) {
        System.out.println("pay with alipay: " + total);
    }

}