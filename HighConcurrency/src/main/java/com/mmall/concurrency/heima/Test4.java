package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

import static com.mmall.concurrency.heima.Sleeper.sleep;

@Slf4j
public class Test4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String re2 = "a\\\\s";
        System.out.println("re2 = " + re2);



        ExecutorService computeService = Executors.newFixedThreadPool(1); // 接收结果的线程池
        ExecutorService resultService = Executors.newFixedThreadPool(1);
        log.debug("开始");
        CompletableFuture.supplyAsync(() -> {
            log.debug("开始");
            sleep(1);
            log.debug("结束");
            return 10;
        }, computeService).thenAcceptAsync((result) -> {
            log.debug("结果为:{}", result);
        }, resultService);

        Future<Integer> submit = computeService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return 10;
            }
        });

        Integer integer = submit.get();
        System.out.println("integer = " + integer);


    }

    private static void test6() {
        ExecutorService consumer = Executors.newFixedThreadPool(1);
        ExecutorService producer = Executors.newFixedThreadPool(1);
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        log.debug("开始");
        producer.submit(() -> {
            log.debug("开始");
            sleep(1);
            log.debug("结束");
            try {
                queue.put(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumer.submit(() -> {
            try {
                Integer result = queue.take();
                log.debug("结果为:{}", result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
