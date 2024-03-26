package com.ktb.mutithread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class NotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue q = new TaskQueue();
        ArrayList<Thread> ts = new ArrayList<Thread>();

        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                log.info("add task: {}" , s);
                q.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        });
        add.start();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread() {
                public void run() {
                    // 执行task:
                    while (true) {
                        String s = q.getTask();
                        log.info("execute task: {}" , s);
                    }
                }
            };
            t.start();
            ts.add(t);
        }
        add.join();
        for (Thread t : ts) {
            t.join();
        }
    }
}

