package com.ktb.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = () -> {
            System.out.println("Hello World");
        };
        executorService.submit(runnable);
    }
}
