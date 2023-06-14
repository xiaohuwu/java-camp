package com.example.springboot16redis.juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 这可以用来控制并发线程的数量
 */
public class Demo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String format = simpleDateFormat.format(new Date());
                    String s = format + " " + Thread.currentThread().getName() + " is workong";
                    System.out.println("s = " + s);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }
}
