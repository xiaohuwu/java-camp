package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import static com.mmall.concurrency.heima.Sleeper.sleep;

@Slf4j(topic = "c.TestCorrectPosture")
public class TestCorrectPostureStep5 {
    static final Object room = new Object();
    static ReentrantLock reentrantLock = new ReentrantLock();
    static  Condition condition1 = reentrantLock.newCondition();
    static  Condition condition2 = reentrantLock.newCondition();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;

    public static void main(String[] args) {
        new Thread(() -> {
                try {
                    reentrantLock.lock();
                    log.debug("有烟没？[{}]", hasCigarette);
                    while (!hasCigarette) {
                        log.debug("没烟，先歇会！");
                        try {
                            condition1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    log.debug("有烟没？[{}]", hasCigarette);
                    if (hasCigarette) {
                        log.debug("可以开始干活了");
                    } else {
                        log.debug("没干成活...");
                    }
                } finally {
                    reentrantLock.unlock();
                }
        }, "小南").start();

        new Thread(() -> {
            try {
                reentrantLock.lock();
                Thread thread = Thread.currentThread();
                log.debug("外卖送到没？[{}]", hasTakeout);
                while (!hasTakeout) {
                    log.debug("没外卖，先歇会！");
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("外卖送到没？[{}]", hasTakeout);
                if (hasTakeout) {
                    log.debug("可以开始干活了");
                } else {
                    log.debug("没干成活...");
                }
            } finally {
                reentrantLock.unlock();
            }
        }, "小女").start();

        sleep(1);
        new Thread(() -> {
            try {
                reentrantLock.lock();
                hasCigarette = true;
                hasTakeout = true;
                log.debug("外卖到了噢！");
                condition2.signal();
                condition1.signal();
            } finally {
                reentrantLock.unlock();
            }
        }, "送外卖的").start();


    }

}
