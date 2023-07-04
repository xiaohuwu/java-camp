package com.ktb.design_pattern.strategy;

public class DealSina implements DealStrategy{

    @Override
    public void dealMethod(String option) {
        String s = "DealSina :" + option;
        System.out.println(s);
    }
}
