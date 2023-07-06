package com.ktb.mutithread.book1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class MyLock implements Lock {
    //绑定线程
    private Thread thread;

    @Override
    public void lock() {
        synchronized (this) {
            while (thread != null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.thread = Thread.currentThread();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long l, TimeUnit timeUnit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        synchronized (this) {
            if (thread != Thread.currentThread()) {
                return;
            }
            thread = null;
            notifyAll();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }




    public static void main(String[] args) {
        MyLock lock = new MyLock();
        lock.lock();
        try {
            System.out.println("第一次获取锁");
            lock.lock();
            try {
                System.out.println("第二次获取锁");
            } finally {
                lock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }



}