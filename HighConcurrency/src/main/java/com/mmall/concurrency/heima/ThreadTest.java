package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadTest {
    public static void main(String[] args) {


        new Thread(() -> {
            log.info("thread 2 start");
            log.info("thread 2 end");
        }).start();

        log.info("main thread end");

        new Thread(() -> {
            log.info("thread 1 start");
            log.info("thread 1 end");
        }).start();
    }
}
