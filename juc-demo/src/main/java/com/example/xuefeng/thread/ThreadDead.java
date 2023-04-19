package com.example.xuefeng.thread;

public class ThreadDead {
    public Integer value = 0;
    public Integer another = 0;

    public void add(int m) {
        synchronized (Counter1.class) { // 获得lockA的锁
            this.value += m;
            synchronized (ThreadDead.class) { // 获得lockB的锁
                this.another += m;
            } // 释放lockB的锁
        } // 释放lockA的锁
    }

    public void dec(int m) {
        synchronized (ThreadDead.class) { // 获得lockB的锁
            this.another -= m;
            synchronized (Counter1.class) { // 获得lockA的锁
                this.value -= m;
            } // 释放lockA的锁
        } // 释放lockB的锁
    }

    public static void main(String[] args) {
        ThreadDead threadDead = new ThreadDead();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    threadDead.add(100);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    threadDead.dec(100);
                }
            }
        }).start();
    }
}
