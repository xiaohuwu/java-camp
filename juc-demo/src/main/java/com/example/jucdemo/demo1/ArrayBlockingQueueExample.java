package com.example.jucdemo.demo1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException
    {
        ArrayBlockingQueue<Integer> priorityBlockingQueue = new ArrayBlockingQueue<>(5);

        //Producer thread
        new Thread(() ->
        {
            int i = 0;
            try
            {
                while (true)
                {
                    priorityBlockingQueue.put(++i);
                    System.out.println("Added : " + i);

                    Thread.sleep(TimeUnit.SECONDS.toMillis(1));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        //Consumer thread
        new Thread(() ->
        {
            try
            {
                while (true)
                {
                    Integer poll = priorityBlockingQueue.take();
                    System.out.println("Polled : " + poll);

                    Thread.sleep(TimeUnit.SECONDS.toMillis(2));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
    }
}
