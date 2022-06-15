package com.ktb.java8;

import com.ktb.java8.model.Person;

public class ThreedJoinTest {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {

            try {
                System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                System.out.println("start");
                Thread.sleep(1000 * 5);
                System.out.println("finish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable,"sub Threed");
        thread.start();
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("main stop ");
    }

}
