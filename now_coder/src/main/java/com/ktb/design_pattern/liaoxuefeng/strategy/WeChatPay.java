package com.ktb.design_pattern.liaoxuefeng.strategy;

public class WeChatPay implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("使用微信支付：" + amount);
        // 具体的支付逻辑
    }
}
