package com.example.jucdemo.basic;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String main = "i am running";
                log.info("main:{}", main);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        log.info("thread.getState():{}", thread.getState());
        thread.start();
        Thread.sleep(100);
        log.info("Thread.currentThread().getState():{}", thread.getState());
    }
}
