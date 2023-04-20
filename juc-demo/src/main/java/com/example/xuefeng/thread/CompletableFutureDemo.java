package com.example.xuefeng.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

@Slf4j
public class CompletableFutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Object> objectCompletableFuture = CompletableFuture.supplyAsync(CompletableFutureDemo::fetchPrice);

        objectCompletableFuture.thenAccept((result)->{
            log.info("result:{}", result);
        });
        objectCompletableFuture.exceptionally((e)->{
             e.printStackTrace();
            return null;
        });
        Thread.sleep(200);
    }

    static Double fetchPrice(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        throw new RuntimeException("fetch price failed!");
    }
}
