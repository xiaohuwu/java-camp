package com.example.jucdemo.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class B {

    public static void main(String[] args) {
        B.Data data = new B.Data();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }

    static class Data {
        private int number = 0;
        public ReentrantLock lock = new ReentrantLock();
        public Condition condition = lock.newCondition();

        //condition.await(); // 等待
        //condition.signalAll(); // 唤醒全部
        //+1
        public void increment() throws InterruptedException {

            try {
                lock.lock();
                while (number != 0) {  //0
                    // 等待
                    condition.await();
                }
                number++;
                System.out.println(Thread.currentThread().getName() + "=>" + number); // 通知其他线程，我+1完毕了
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void decrement() throws InterruptedException {
            try {
                lock.lock();
                while (number == 0) {
                    condition.await();
                }
                number--;
                System.out.println(Thread.currentThread().getName() + "=>" + number); // 通知其他线程，我-1完毕了
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}


