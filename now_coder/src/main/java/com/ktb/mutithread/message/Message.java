package com.ktb.mutithread.message;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;

@Slf4j
/**
 * 简易版的消息队列
 */
public class Message {
    private int id;

    private Object message;

    public Message(int id, Object message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message=" + message +
                '}';
    }

    public static MessageQueue messageQueue = new MessageQueue();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    int i1 = random.nextInt(10);
                    Message message = new Message(finalI, i1);
                    messageQueue.put(message);

                }
            }, "生产者:" + i).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Message message = messageQueue.get();
                    log.info("获取消息 = " + message);
                }
            }
        }, "消费者:").start();

        Thread.sleep(10000);
    }
}


@Slf4j
class MessageQueue {
    public ConcurrentLinkedDeque<Message> linkedList = new ConcurrentLinkedDeque<>();
    private long size = 2;

    public Message get() {
        synchronized (this) {
            while (linkedList.isEmpty()) {
                try {
                    log.info("队列为空 请等待");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message o = linkedList.removeFirst();
            this.notifyAll();
            return o;
        }
    }

    public void put(Message message) {
        synchronized (this) {
            while (linkedList.size() == size) {
                try {
                    log.info("队列满 请等待");
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("放入消息 = " + message);
            linkedList.addLast(message);
            this.notifyAll();
        }
    }


}
