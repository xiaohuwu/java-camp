package com.ktb.muke;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 现在有2000个客户端同时请求，
 * 但是服务器只允许200个客户端同时修改。
 * 并打印出最后的结果
 */
public class CountExample1 {
//    public static AtomicInteger anInt = new AtomicInteger(0);
    public static int i = 0;

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
        System.out.println("i = " + i);
    }

    private static synchronized void countNumber() {
        i++;
    }
}
