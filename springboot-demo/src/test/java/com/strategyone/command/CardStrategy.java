package com.strategyone.command;

import com.strategyone.RechargeTypeEnum;
import com.strategyone.Strategy;

public class CardStrategy implements Strategy {
 
    @Override
    public Double calRecharge(Double charge, RechargeTypeEnum type) {
       return charge+charge*0.01;
    }
 
}