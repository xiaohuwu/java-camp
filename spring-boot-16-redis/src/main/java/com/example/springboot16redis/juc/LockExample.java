package com.example.springboot16redis.juc;

import com.example.springboot16redis.TestClassLoader;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockExample  extends TestClassLoader{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    public void func() {
        writeLock.lock();
        try {
            for (int i = 0; i < 20; i++) {
                System.out.print(Thread.currentThread().getName() + "  " + i + "\n");
            }
        } finally {
            writeLock.unlock(); // 确保释放锁，从而避免发生死锁。
        }
    }


    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                lockExample.func();
            });
        }
        TestClassLoader testClassLoader = new TestClassLoader();

        ArrayList<Integer> list = testClassLoader.list;

    }


}
