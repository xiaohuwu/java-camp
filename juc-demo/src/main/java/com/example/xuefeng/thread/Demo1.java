package com.example.xuefeng.thread;

import java.util.concurrent.atomic.AtomicInteger;

//原子类演示
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    int i1 = atomicInteger.incrementAndGet();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    int i1 = atomicInteger.decrementAndGet();
                }
            }
        });
        thread1.start();
        thread.start();
        thread1.join();
        thread.join();
        System.out.println("atomicInteger.get() = " + atomicInteger.get());
    }

}
