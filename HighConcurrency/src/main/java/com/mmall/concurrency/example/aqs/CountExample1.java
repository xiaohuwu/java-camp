package com.mmall.concurrency.example.aqs;

import com.mmall.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
@NotThreadSafe
public class CountExample1 {

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static int count = 0;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(threadTotal);
        final CyclicBarrier barrier = new CyclicBarrier(clientTotal, () -> log.info("count:{}", count));

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    add();
                } catch (Exception e) {
                    log.error("exception", e);
                } finally {
                    try {
                        int numberWaiting = barrier.getNumberWaiting();
                        log.info("numberWaiting:{}", numberWaiting);
                        barrier.await(); // 确保即使发生异常也调用await，以防止阻塞其他线程
                    } catch (InterruptedException | BrokenBarrierException e) {
                        log.error("Barrier exception", e);
                    }
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES); // 等待直到所有任务完成
    }

    private synchronized static void add() {
        count++;
    }
}
