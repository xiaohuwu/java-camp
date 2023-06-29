package com.ktb.mutithread;

import java.sql.Connection;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
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
            System.out.println("m1");
            m2();
        } finally {
            lock.unlock();
        }
    }

    public static void m2(){
        lock.lock();
        try {
            System.out.println("m2");
        } finally {
            lock.unlock();
        }
    }



}
