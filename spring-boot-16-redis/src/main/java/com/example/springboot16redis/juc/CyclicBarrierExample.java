package com.example.springboot16redis.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier 是 Java 并发包中的一个类，它可以让一组线程达到一个同步点后再一起继续执行。
 * 每当一个线程到达同步点，它就会调用 await() 方法并阻塞，直到所有的线程都到达同步点，
 * 然后所有线程都会被解除阻塞，同时 CyclicBarrier 会重置，以便下一次使用。
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {

        final int totalPlayer = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalPlayer, new Runnable() {
            @Override
            public void run() {
                System.out.println("All players are ready, game start!");
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(totalPlayer);

        for (int i = 0; i < totalPlayer; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Player " + Thread.currentThread().getName() + " is ready");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
    }
}

