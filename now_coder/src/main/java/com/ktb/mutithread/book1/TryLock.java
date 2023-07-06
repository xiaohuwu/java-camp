package com.ktb.mutithread.book1;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 可重入锁
 */
public class TryLock {

    static Object object = new Object();
    public static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                method1();

            }
        });
        thread.start();
        thread.join();
    }

    private static void method1() {
        writeLock.lock();
        System.out.println("in method1");
        method2();
        writeLock.unlock();

    }

    private  static void method2() {
        writeLock.lock();
        System.out.println("in method2");
        writeLock.unlock();
    }


}
