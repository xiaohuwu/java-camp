package com.ktb.muke;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeadLock {
    public static int value = 0;
    public static int another = 0;
    public TaskQueue lockA = new TaskQueue();
    public TaskQueue lockB = new TaskQueue();


    public void add(int m) {
        synchronized(lockA) { // 获得lockA的锁
            try {
                Thread.sleep(100); // 增加死锁发生的可能性
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            this.value += m;
            synchronized(lockB) { // 获得lockB的锁
                this.another += m;
            } // 释放lockB的锁
        } // 释放lockA的锁
    }


    public void dec(int m) {
        synchronized(lockB) { // 获得lockA的锁
            try {
                Thread.sleep(100); // 增加死锁发生的可能性
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            this.another += m;
            synchronized(lockA) { // 获得lockB的锁
                this.value += m;
            } // 释放lockB的锁
        } // 释放lockA的锁
    }





    public static void main(String[] args) throws InterruptedException {
        DeadLock counter  = new DeadLock();
        Thread thread1 =  new Thread(new Runnable() {
            @Override
            public void run() {
                counter.add(12);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.dec(12);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Counter.value = " + DeadLock.value);
        System.out.println("Counter.another = " + DeadLock.another);
    }

}
