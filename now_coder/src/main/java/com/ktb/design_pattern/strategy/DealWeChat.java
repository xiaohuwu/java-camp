package com.ktb.design_pattern.strategy;

public class DealWeChat implements DealStrategy{
    @Override
    public void dealMethod(String option) {
        String s = "DealWeChat :" + option;
        System.out.println(s);
    }
}
