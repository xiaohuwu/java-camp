package com.mmall.concurrency.heima;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@FunctionalInterface
interface RejectPolicy<T> {
    void reject(MyBlockingQueue<T> queue, T task);
}

@Slf4j
public class ThreadPool {
    // 任务队列
    private MyBlockingQueue<Runnable> taskQueue;

    // 线程集合
    private HashSet<Worker> workers = new HashSet<>();

    // 核心线程数
    private int coreSize;

    // 获取任务时的超时时间
    private long timeout;

    private TimeUnit timeUnit;

    private RejectPolicy<Runnable> rejectPolicy;


    public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit, int queueCapcity, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new MyBlockingQueue<Runnable>(queueCapcity);
        this.rejectPolicy = rejectPolicy;
    }


    // 执行任务
    public void execute(Runnable task) throws InterruptedException {
        // 当任务数没有超过 coreSize 时，直接交给 worker 对象执行
        // 如果任务数超过 coreSize 时，加入任务队列暂存
        synchronized (workers) {
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);
                log.debug("新增 worker{}, {}", worker, task);
                workers.add(worker);
                worker.start();
            } else {
                taskQueue.put(task);
            }
        }
    }


    class Worker extends Thread {
        Runnable task;


        public Worker(Runnable task) {
            this.task = task;
        }

        @SneakyThrows
        @Override
        public void run() {
            while (task != null || (task = taskQueue.take()) != null) {
                task.run();
                task = null;
            }
            synchronized (workers) {
                log.debug("worker 被移除{}", this);
                workers.remove(this);
            }
        }

    }


}


class MyBlockingQueue<T> {

    // 1. 任务队列
    private Deque<T> queue = new ArrayDeque<>();

    // 2. 锁
    private ReentrantLock lock = new ReentrantLock();

    // 3. 生产者条件变量
    private Condition fullWaitSet = lock.newCondition();

    // 4. 消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();

    // 5. 容量
    private int capcity;

    public MyBlockingQueue(int capcity) {
        this.capcity = capcity;
    }

    public  void put(T task) throws InterruptedException {
        lock.lock(); // 获取锁
        try {
            while (queue.size() == capcity) {
                fullWaitSet.await(); // 等待队列非满
            }
            queue.add(task);
            emptyWaitSet.signalAll(); // 通知等待的消费者线程
        } finally {
            lock.unlock(); // 释放锁
        }
    }

    public T take() throws InterruptedException {
        lock.lock(); // 获取锁
        try {
            while (queue.isEmpty()) {
                emptyWaitSet.await(); // 等待队列非空
            }
            T task = queue.remove();
            fullWaitSet.signalAll(); // 通知等待的生产者线程
            return task;
        } finally {
            lock.unlock(); // 释放锁
        }
    }


}
