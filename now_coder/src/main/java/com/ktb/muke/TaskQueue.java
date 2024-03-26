package com.ktb.muke;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void add(String item) {
        try {
            lock.lock();
            queue.add(item);
            condition.signalAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public String get() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        String poll = queue.poll();
        return poll;
    }

    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("\"等待结果\" = " + "等待结果");
                String s = taskQueue.get();
                System.out.println("s = " + s);
            }
        }).start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        taskQueue.add("123");
    }


}
