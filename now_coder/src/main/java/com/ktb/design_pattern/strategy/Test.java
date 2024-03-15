package com.ktb.design_pattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static List<DealContext> list = new ArrayList<>();
    static{
        list.add( new DealContext("sina",new DealSina()));
        list.add( new DealContext("wechat",new DealWeChat()));
    }

    public static void main(String[] args) {
        String type = "wechat";
        String message = "hello world";
        DealContext target = null;
        for (DealContext dealContext : list) {
            if (dealContext.getType().equals(type)) {
                target = dealContext;
                break;
            }
        }
        if (target != null) {
            DealStrategy deal = target.getDeal();
            deal.dealMethod(message);
        }

    }
}
