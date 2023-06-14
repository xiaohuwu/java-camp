package com.example.springboot16redis.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *Java的 CountDownLatch 是一种同步工具类，它允许一个或多个线程等待一组其他线程完成操作。
 * CountDownLatch的内部计数器被初始化为一个正整数，代表需要等待的事件数。
 * countDown()方法会减少计数器的值，而await()方法会阻塞调用线程，直到计数器的值变为零。
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        final int totalFile = 100;
        CountDownLatch countDownLatch = new CountDownLatch(totalFile);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < totalFile; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Downloaded file " + Thread.currentThread().getName());

                    // 每下载完成一个文件，计数器减1
                    countDownLatch.countDown();
                }
            });
        }

        // 主线程等待所有文件下载完成
        countDownLatch.await();
        System.out.println("All files have been downloaded, start to process...");

        executorService.shutdown();
    }
}

