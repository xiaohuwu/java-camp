package com.ktb.mutithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample1 {
    private final static int threadCount = 200;
    static ThreadPoolExecutor exec = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>());

    public static void main(String[] args) throws InterruptedException {


        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
//        countDownLatch.await();
        countDownLatch.await(2, TimeUnit.MILLISECONDS);
        System.out.println("finish");
        exec.shutdown();
    }


    private static void test(int threadNum) throws Exception {
        Thread.sleep(1000);
        System.out.println("threadNum: " + threadNum);
        Thread.sleep(1000);
        System.out.println("exec.getActiveCount() = " + exec.getActiveCount());
    }


}
