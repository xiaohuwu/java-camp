package com.ktb.design_pattern.liaoxuefeng.adpter;

import java.util.concurrent.Callable;

public class Task implements Callable<Long> {
    private long num;
    public Task(long num) {
        this.num = num;
    }

    @Override
    public Long call() throws Exception {
        long r = 0;
        for (long n = 1; n <= this.num; n++) {
            r = r + n;
        }
        System.out.println("Result: " + r);
        return r;
    }

    public static void main(String[] args) {
        Callable<Long> callable = new Task(123450000L);
        Thread thread = new Thread(new RunnableAdapter(callable)); // compile error!
        thread.start();


    }
}
