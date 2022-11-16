package com.ktb;

public class DebugAdvance {
    public static void condition() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
        }
        MyThread myThread = new MyThread();
        Thread test1 = new Thread(myThread, "test1");
        Thread test2 = new Thread(myThread, "test2");
        Thread test3 = new Thread(myThread, "test3");
        test1.start();
        test2.start();
        test3.start();
    }

    public static void main(String[] args) {
        condition();
    }

    public static  class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName()+"进入");
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName()+"离开");
            }
        }
    }
}
