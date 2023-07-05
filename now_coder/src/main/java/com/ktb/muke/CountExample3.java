package com.ktb.muke;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 现在有2000个客户端同时请求，
 * 但是服务器只允许200个客户端同时修改。
 * 并打印出最后的结果
 */
public class CountExample3 {
    public static AtomicReference<Integer> anInt = new AtomicReference(0);

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
        System.out.println("i = " + anInt.get());
    }

    private static  void countNumber() {
        while (true) {
            Integer integer = anInt.get();
            Integer newData = integer + 1;
            if (anInt.compareAndSet(integer, newData)) { // anInt 里面的初始值和 integer相等，就设置新值
                break;
            }
        }
    }


}
