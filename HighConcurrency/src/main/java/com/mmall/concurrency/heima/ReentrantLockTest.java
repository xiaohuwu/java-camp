package com.mmall.concurrency.heima;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockTest {
    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition condition1 = reentrantLock.newCondition();

    public static void main(String[] args) {
        new Thread(()->{
            // 每个Condition 就是一个休息室
            reentrantLock.lock();
            log.info("start");
            try {
                log.info("await");
                condition1.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("continue");
            reentrantLock.unlock();
        }).start();

        Sleeper.sleep(3);
        reentrantLock.lock();
        log.info("signal");
        condition1.signal();
        reentrantLock.unlock();
    }



}
