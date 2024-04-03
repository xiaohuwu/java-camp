package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Test27 {
    private static int flag = 0;
    private static ReentrantLock reentrantLock = new ReentrantLock();
    static Thread t1, t2, t3;

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                LockSupport.park();
                log.info("a");
                LockSupport.unpark(t2);
            }
        }, "t1");
        t1.start();

        t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                LockSupport.park();
                log.info("b");
                LockSupport.unpark(t3);
            }
        }, "t2");
        t2.start();


        t3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                LockSupport.park();
                log.info("c");
                LockSupport.unpark(t1);
            }
        }, "t3");
        t3.start();

        LockSupport.unpark(t1);

    }
}
