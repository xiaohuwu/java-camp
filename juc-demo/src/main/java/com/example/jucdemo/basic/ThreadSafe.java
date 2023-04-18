package com.example.jucdemo.basic;

public class ThreadSafe {
    public static Integer count = 0;
    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    synchronized (object) {
                        count += 1;
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                  /*  synchronized (object) {*/
                        count -= 1;
                   /* }*/
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("count = " + count);
    }
}
