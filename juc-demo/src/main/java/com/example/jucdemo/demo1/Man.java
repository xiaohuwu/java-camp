package com.example.jucdemo.demo1;

import java.util.concurrent.ArrayBlockingQueue;

public class Man {

    ArrayBlockingQueue queue = new ArrayBlockingQueue<Integer>(64);

    public static void main(String[] args) {
        Man man = new Man();
        new Thread(() -> {
            man.getRunnable1();
        }).start();
        new Thread(() -> {
            man.getRunnable2();
        }).start();
    }




    public void getRunnable1() {
        for (int i = 0; i < 8; i++) {
            System.out.println("生产出：" + i + "个");
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("---------------生产完毕-----------------");
    }

    public void getRunnable2() {
        for (int i = 0; i < 8; i++) {
            try {
                int num = (int) queue.take();
                System.out.println("取出出：" + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
