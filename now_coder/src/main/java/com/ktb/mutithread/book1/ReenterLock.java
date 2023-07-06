package com.ktb.mutithread.book1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁示例代码
 */
public class ReenterLock implements Runnable {
    ReentrantLock reentrantLock = new ReentrantLock();
    public int j = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            reentrantLock.lock();
            reentrantLock.lock();
            try {
                j++;
            } catch (Exception e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
            reentrantLock.unlock();
        }
    }

    public int getI() {
        return j;
    }

    public void setI(int i) {
        this.j = i;
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread thread = new Thread(reenterLock);
        Thread thread2 = new Thread(reenterLock);
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("reenterLock.getI() = " + reenterLock.getI());
    }
}
