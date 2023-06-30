package com.ktb.mutithread.aqs;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample1 {

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
//            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                  e.printStackTrace();
                }
            });
        }
        executor.shutdown();

        new Thread(() -> System.out.println("hello world "));
    }


    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        System.out.println("is ready: " + threadNum);
        barrier.await();
        System.out.println( threadNum +  " continue");
    }




}
