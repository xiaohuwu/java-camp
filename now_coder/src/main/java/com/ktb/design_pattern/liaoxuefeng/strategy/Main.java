package com.ktb.design_pattern.liaoxuefeng.strategy;

public class Main {
    public static void main(String[] args) {
        PaymentStrategy strategy = new CreditCardPayment();
        PaymentContext context = new PaymentContext(strategy);
        context.pay(100.0);

        strategy = new WeChatPay();
        context = new PaymentContext(strategy);
        context.pay(200.0);
    }
}
