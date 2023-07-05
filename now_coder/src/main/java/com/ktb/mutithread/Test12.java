package com.ktb.mutithread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test12 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                String s = "continue";
                log.info("s:{}", s);
                if (Thread.currentThread().isInterrupted()) {
                    log.info("被打断了, 退出循环");
                    break;
                }
            }
        }, "t1");
        t1.start();
        Thread.sleep(4000);
        log.info("interrepted");
        t1.interrupt();
    }
}
