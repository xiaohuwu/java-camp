package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class ParkTest1 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            LockSupport.park();
            log.info("1");
        });
        thread.start();

        log.info("2");
        LockSupport.unpark(thread);

    }
}
