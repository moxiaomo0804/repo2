package com.strategyone.command;

import com.strategyone.RechargeTypeEnum;
import com.strategyone.Strategy;

public class EBankStrategy implements Strategy {
 
    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
       return charge*0.85;
    }
 
}