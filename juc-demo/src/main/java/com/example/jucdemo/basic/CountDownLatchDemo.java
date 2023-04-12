package com.example.jucdemo.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        for (int i = 0; i < 10; i++) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               log.info(Thread.currentThread().getName() + "run-");
                countDownLatch.countDown();
            });
            executorService.shutdown();
        }

        countDownLatch.await();
        log.info("end");
    }
}
