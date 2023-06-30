package com.ktb.mutithread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
@Slf4j
public class RetryLock {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try {
            m1();
        } finally {
            lock.unlock();
        }
    }

    public static void m1(){
        lock.lock();
        try {
            log.info("m1");
            m2();
        } finally {
            lock.unlock();
        }
    }

    public static void m2(){
        lock.lock();
        try {
            log.info("m2");
        } finally {
            lock.unlock();
        }
    }



}
