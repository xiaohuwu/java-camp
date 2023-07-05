package com.ktb.mutithread;

/**
 * java 多线程实现交替打印 1 2
 */
public class Test2 {
    static int flag = 1;
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i < 5; i++) {
                    while (flag != 1 ) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag = 2;
                    System.out.println("a");
                    obj.notifyAll();
                }
            }
        }, "t1");
        t1.start();


        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i < 5; i++) {
                    while (flag != 2) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag = 3;
                    System.out.println("b");
                    obj.notifyAll();
                }
            }
        }, "t2");
        t2.start();

        Thread t3 = new Thread(() -> {
            synchronized (obj) {
                for (int i = 0; i < 5; i++) {
                    while (flag != 3) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag = 1;
                    System.out.println("c");
                    obj.notifyAll();
                }
            }
        }, "t3");
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
