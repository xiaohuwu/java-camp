package com.ktb.mutithread;

public class TaskQueueTest {

    public static void main(String[] args) {

        TaskQueue taskQueue = new TaskQueue();




        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start new");
                taskQueue.getTask();
            }
        });
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start new thread!");
                taskQueue.addTask("88");
            }
        }).start();


        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
