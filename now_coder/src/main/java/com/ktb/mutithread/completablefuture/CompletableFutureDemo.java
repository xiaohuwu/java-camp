package com.ktb.mutithread.completablefuture;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * 两个独立的task 都执行完后，程序再往下执行。
 */
@Slf4j
public class CompletableFutureDemo {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<BigDecimal> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double d = 5 + Math.random() * 20;
            return new BigDecimal(d).setScale(2, RoundingMode.DOWN);
        });

        CompletableFuture<Void> voidCompletableFuture = task1.thenAccept(bigDecimal -> {
            double v = bigDecimal.doubleValue();
            log.info("v = " + v);
        });


        CompletableFuture<BigDecimal> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double d = 5 + Math.random() * 20;
            return new BigDecimal(d).setScale(2, RoundingMode.DOWN);
        });

        CompletableFuture<Void> voidCompletableFuture1 = task2.thenAccept(bigDecimal -> {
            double v = bigDecimal.doubleValue();
            log.info("v = " + v);
        });

        CompletableFuture<Void> combined = voidCompletableFuture.thenCombine(voidCompletableFuture1, (unused1, unused2) -> null);
        combined.thenAccept(new Consumer<Void>() {
            @Override
            public void accept(Void unused) {
                log.info("done 11111");
            }
        });
        combined.join();
        log.info("done");
    }
}
