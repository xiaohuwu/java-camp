package com.mmall.concurrency.heima;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) {
        // 创建一个容量为 10 的阻塞队列
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

        // 生产者线程
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(1000); // 模拟耗时的生产过程
                    String message = "Message " + i;
                    queue.put(message); // 将消息放入队列
                    System.out.println("Produced: " + message);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // 消费者线程
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String message = queue.take(); // 从队列中取出消息
                    System.out.println("Consumed: " + message);
                    if (message.equals("Message 5")) {
                        break; // 当接收到最后一条消息时退出循环
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 启动生产者和消费者线程
        producer.start();
        consumer.start();
    }
}
