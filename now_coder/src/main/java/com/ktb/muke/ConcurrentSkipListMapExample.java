package com.ktb.muke;

import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.*;

@Slf4j
public class ConcurrentSkipListMapExample {
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;
    public static Queue result = new ArrayBlockingQueue(5000);

    public static void main(String[] args) throws Exception {
        ExecutorService executors = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(5000);
        Semaphore semaphore = new Semaphore(200);
        for (int i = 0; i < 5000; i++) {
            int finalI = i;
            executors.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        update(finalI);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();

                }
            });
        }
        countDownLatch.await();
        executors.shutdown();
        log.info("result.size():{}", result.size());

    }

    private static void update(int i) {
        result.add(i);
    }
}
