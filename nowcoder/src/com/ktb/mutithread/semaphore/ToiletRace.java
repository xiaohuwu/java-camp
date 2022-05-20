package com.ktb.mutithread.semaphore;

import com.ktb.mutithread.semaphore.Employee;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ToiletRace {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors
            .newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Employee(String.valueOf(i), s));
        }
        threadPool.shutdown();
    }



}
