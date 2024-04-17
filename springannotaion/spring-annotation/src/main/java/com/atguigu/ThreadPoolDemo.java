package com.atguigu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 强制转换为ThreadPoolExecutor，以便访问线程池的状态方法
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;

        // 提交一些任务给线程池执行
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executorService.submit(() -> {
                System.out.println("Executing task " + taskId + " using thread " + Thread.currentThread().getName());
                try {
                    // 任务执行一段时间
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // 模拟运行一段时间后获取线程池状态
        Thread.sleep(3000); // 等待一些任务完成

        // 获取并打印线程池的状态信息
        System.out.println("Pool Size: " + pool.getPoolSize());
        System.out.println("Active Threads: " + pool.getActiveCount());
        System.out.println("Completed Tasks: " + pool.getCompletedTaskCount());
        System.out.println("Total Tasks: " + pool.getTaskCount());

        // 关闭线程池
        executorService.shutdown();
    }
}

