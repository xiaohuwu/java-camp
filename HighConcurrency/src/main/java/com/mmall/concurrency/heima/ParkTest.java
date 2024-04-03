package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class ParkTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.info("start:{}", "start");
            Sleeper.sleep(3);
            LockSupport.park();
            LockSupport.park();
            log.info("继续运行");
        });
        t1.start();

        log.info("unpark ....");
        LockSupport.unpark(t1);
        LockSupport.unpark(t1);
    }
}
