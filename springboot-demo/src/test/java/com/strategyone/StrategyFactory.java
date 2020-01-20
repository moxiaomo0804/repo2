package com.strategyone;

import com.strategyone.command.BusiAcctStrategy;
import com.strategyone.command.CardStrategy;
import com.strategyone.command.EBankStrategy;
import com.strategyone.command.MobileStrategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {
 
    private static StrategyFactory factory = new StrategyFactory();
    private StrategyFactory(){
    }
    private static Map strategyMap = new HashMap<>();
    static{
       strategyMap.put(RechargeTypeEnum.E_BANK.value(), new EBankStrategy());
       strategyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.value(), new BusiAcctStrategy());
       strategyMap.put(RechargeTypeEnum.MOBILE.value(), new MobileStrategy());
       strategyMap.put(RechargeTypeEnum.CARD.value(), new CardStrategy());
    }
    public Strategy creator(Integer type){
        return (Strategy) strategyMap.get(type);
    }
    public static StrategyFactory getInstance(){
       return factory;
    }
}