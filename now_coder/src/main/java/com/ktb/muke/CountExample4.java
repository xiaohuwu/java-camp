package com.ktb.muke;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 现在有2000个客户端同时请求，
 * 但是服务器只允许200个客户端同时修改。
 * 并打印出最后的结果
 */
public class CountExample4 {
    public static int anInt;
    private final static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public static void main(String[] args) throws InterruptedException {


        Semaphore semaphore = new Semaphore(200);
        CountDownLatch countDownLatch = new CountDownLatch(5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        countNumber();
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("i = " + anInt);
    }

    private static void countNumber() {
        writeLock.lock();
        try {
            anInt++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }


}
