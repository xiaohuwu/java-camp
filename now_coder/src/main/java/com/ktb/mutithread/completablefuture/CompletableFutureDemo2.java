package com.ktb.mutithread.completablefuture;

import java.util.concurrent.*;

public class CompletableFutureDemo2 {

    public static ExecutorService service = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main start ...");

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("开启异步任务1...");
            int i = 10 / 1;
            return i;
        }, service);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("开启异步任务2...");
            return "hello world!";
        }, service);

        future1.runAfterBoth(new CompletableFuture() {
            @Override
            public boolean complete(Object value) {
                return super.complete(value);
            }
        }, new Runnable() {
            @Override
            public void run() {
                System.out.println("I am runing");
            }
        });

        System.out.println("main end ...");


    }
}
