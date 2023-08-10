package com.ktb.mutithread.completablefuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * https://blog.csdn.net/weixin_45080497/article/details/129130691
 *
 */
@Slf4j
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        completableTash();
        Thread.sleep(5000);
    }

    public static void completableTash() {
        CompletableFuture.supplyAsync(() -> {
            log.info("1");
            return "1";
        }).thenApplyAsync(s -> {
            log.info("param:{}", s);
            return "2";
        }).thenAccept(result -> {
            log.info("result:{}", result);
        });
    }

}
