package com.strategytwo.command;

import com.strategytwo.PayStrategy;

public class EbankPay implements PayStrategy {

    public void pay(double total) {
        System.out.println("pay with ebankpay: " + total*2);
    }

}