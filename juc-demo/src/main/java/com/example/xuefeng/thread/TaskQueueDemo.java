package com.example.xuefeng.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class TaskQueueDemo {
    public static void main(String[] args) {
        MyTaskQueue taskQueue = new MyTaskQueue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    String s = "t-" + Math.random();
                    System.out.println("add task: " + s);
                    taskQueue.addTask(s);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    try {
                        String s = taskQueue.getTask();
                        System.out.println("execute task: " + s);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        }).start();

    }
}




@Slf4j
class MyTaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        boolean add = this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }
}
