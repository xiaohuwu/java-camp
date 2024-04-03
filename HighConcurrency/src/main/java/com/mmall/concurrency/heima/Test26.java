package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Test26 {
    private static int flag = 0;
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition condition = reentrantLock.newCondition();
    private static Condition condition2 = reentrantLock.newCondition();
    private static Condition condition3 = reentrantLock.newCondition();
    public static void main(String[] args) {

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    reentrantLock.lock();
                    while (flag !=0){
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    log.info("a");
                    flag = 1;
                    condition2.signalAll();
                } finally {
                    reentrantLock.unlock();
                }
            }
        },"t1").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    reentrantLock.lock();
                    while (flag != 1){
                        try {
                            condition2.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    log.info("b");
                    flag = 2;
                    condition3.signalAll();
                } finally {
                    reentrantLock.unlock();
                }
            }
        },"t2").start();


        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    reentrantLock.lock();
                    while (flag != 2){
                        try {
                            condition3.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    log.info("c");
                    flag = 0;
                    condition.signalAll();
                } finally {
                    reentrantLock.unlock();
                }
            }
        },"t3").start();
    }
}
