package com.example.jucdemo.basic;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureDemo {


    public static void main(String[] args) throws InterruptedException {
        // 创建异步执行任务:
//        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(new Supplier<Double>() {
//            @Override
//            public Double get() {
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                }
//                if (Math.random() < 0.3) {
//                    throw new RuntimeException("fetch price failed!");
//                }
//                return 5 + Math.random() * 20;
//            }
//        });
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(new Supplier<Double>() {
            @Override
            public Double get() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                if (Math.random() < 0.3) {
                    throw new RuntimeException("fetch price failed!");
                }
                return 5 + Math.random() * 20;
            }
        });
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }


}
