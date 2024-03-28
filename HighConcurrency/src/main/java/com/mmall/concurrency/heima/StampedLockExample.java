package com.mmall.concurrency.heima;

import java.util.concurrent.locks.StampedLock;

public class StampedLockExample {
    private final StampedLock lock = new StampedLock();
    private int sharedState;

    public void write(int newValue) {
        long stamp = lock.writeLock(); // 获取写锁
        try {
            sharedState = newValue; // 写操作
        } finally {
            lock.unlockWrite(stamp); // 释放写锁
        }
    }

    public int read() {
        long stamp = lock.readLock(); // 获取读锁
        try {
            return sharedState; // 读操作
        } finally {
            lock.unlockRead(stamp); // 释放读锁
        }
    }

    public int optimisticRead() {
        long stamp = lock.tryOptimisticRead(); // 尝试获取乐观读锁
        int currentState = sharedState; // 读取状态
        if (!lock.validate(stamp)) { // 检查在读取数据之后是否没被写锁获取过？没获取过返回true 获取过返回false
            stamp = lock.readLock(); // 获取一个悲观读锁
            try {
                currentState = sharedState; // 重新读取状态
            } finally {
                lock.unlockRead(stamp); // 释放读锁
            }
        }
        return currentState; // 返回读取的状态
    }
}
