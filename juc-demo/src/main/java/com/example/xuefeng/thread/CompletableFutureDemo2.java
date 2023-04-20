package com.example.xuefeng.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CompletableFutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "结果1";
        });

        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "结果2";
        });

        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "结果3";
        });



        // 等待所有任务完成，并获取它们的结果
        CompletableFuture.allOf(task1, task2, task3).join();
        String task1_result = task1.get();
        String task2_result = task2.get();
        String task3_result = task3.get();
        log.info("task1_result:{}", task1_result);
        log.info("task2_result:{}", task2_result);
        log.info("task3_result:{}", task3_result);
    }
}
