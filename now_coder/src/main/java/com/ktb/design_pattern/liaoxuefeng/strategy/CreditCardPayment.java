package com.ktb.design_pattern.liaoxuefeng.strategy;

public class CreditCardPayment implements PaymentStrategy{
    public void pay(double amount) {
        System.out.println("使用信用卡支付：" + amount);
        // 具体的支付逻辑
    }
}
