package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;

@Slf4j
public class CyclicBarrierExample {

    public static void main(String[] args) {
        final int parties = 4;
        final CyclicBarrier barrier = new CyclicBarrier(parties, () -> log.info("所有子任务完成当前阶段，可以进入下一阶段"));
        for (int i = 0; i < parties * 2; i++) {
            new Thread(new SubTask(barrier)).start();
        }
    }

    static class SubTask implements Runnable {
        private final CyclicBarrier barrier;

        SubTask(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                log.info(Thread.currentThread().getName() + " 正在执行任务");
                Thread.sleep(1000); // 模拟任务执行时间
                log.info(Thread.currentThread().getName() + " 完成任务，等待其他任务完成");
                barrier.await(); // 等待其他线程
                log.info(Thread.currentThread().getName() + " 开始执行下一阶段任务");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
