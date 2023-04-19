package com.example.xuefeng.thread;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        Counter1 counter = new Counter1();
        new Thread(() -> {
            System.out.println(Arrays.toString(counter.get()));
        }).start();

        new Thread(() -> {
            System.out.println(Arrays.toString(counter.get()));
        }).start();

        new Thread(() -> {
            System.out.println(Arrays.toString(counter.get()));
        }).start();


//        new Thread(() -> {
//            counter.inc(1);
//        }).run();
    }
}




class Counter1 {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        wlock.lock(); // 加写锁
        try {
            counts[index] += 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();        }
        } finally {
            wlock.unlock(); // 释放写锁
        }
    }

    public int[] get()  {
        rlock.lock(); // 加读锁
        try {
            System.out.println("reading...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();        }
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock(); // 释放读锁
        }
    }
}