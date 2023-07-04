package com.ktb.mutithread;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Test35 {
    public static void main(String[] args) throws InterruptedException {
        DecimalAccountCas decimalAccountCas = new DecimalAccountCas(new BigDecimal("10000"));
        DecimalAccount.demo(decimalAccountCas);
        BigDecimal balance = decimalAccountCas.getBalance();
        System.out.println("balance = " + balance);
    }
}


class DecimalAccountCas implements DecimalAccount {
    private AtomicReference<BigDecimal> balance;

    public DecimalAccountCas(BigDecimal bigDecimal) {
        this.balance = new AtomicReference<>(bigDecimal);
    }


    @Override
    public BigDecimal getBalance() {
        return balance.get();
    }

    @Override
    public void withDraw(BigDecimal amount) {
        while (true) {
            BigDecimal pre = balance.get();
            BigDecimal next = pre.subtract(amount);
            if (balance.compareAndSet(pre, next)) {
                break;
            }
        }
    }
}

interface DecimalAccount {
    public BigDecimal getBalance();

    public void withDraw(BigDecimal amount);

    public static void demo(DecimalAccount decimalAccount) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    decimalAccount.withDraw(new BigDecimal("10"));
                }
            });
            thread.start();
            list.add(thread);
        }
        for (Thread thread : list) {
            thread.join(); //等待thread线程执行结束
        }
    }
}