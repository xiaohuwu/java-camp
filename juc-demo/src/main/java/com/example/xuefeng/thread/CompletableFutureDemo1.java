package com.example.xuefeng.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Slf4j
public class CompletableFutureDemo1 {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(() -> queryCode("石油"))
                .thenApplyAsync((String code) -> fetchPrice(code))
                .thenAccept((item) -> {
                    log.info("item:{}", item);
                });
        Thread.sleep(2000);
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }

}
