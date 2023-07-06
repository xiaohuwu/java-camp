package com.ktb.mutithread.book1;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListMutiThread {
    public static void main(String[] args) throws InterruptedException {
        List list = new CopyOnWriteArrayList();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    list.add(i);
                }
            }
        });
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    list.add(i);
                }
            }
        });
        thread1.start();
        thread.join();
        thread1.join();

        System.out.println("list.size() = " + list.size());

    }
}
