package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestDeadLock {
    static Object A = new Object();
    static Object B = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (A) {
                log.info("lock A");
                Sleeper.sleep(1);
                synchronized (B) {
                    log.info("lock B");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (B) {
                log.info("lock B");
                Sleeper.sleep(1);
                synchronized (A) {
                    log.info("lock A");
                }
            }
        }).start();

    }

}
