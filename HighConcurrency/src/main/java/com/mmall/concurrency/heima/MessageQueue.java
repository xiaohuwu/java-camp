package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class MessageQueue {
    public LinkedList<Message> list = new LinkedList<>();
    private int capcity;

    public MessageQueue(int capcity) {
        this.capcity = capcity;
    }

    private Message get() {
        synchronized (list) {
            while (list.isEmpty()) {
                log.info("队列为空");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //从队列头部获取并返回
            Message message = list.removeFirst();
            log.info("已消费 message:{}", message);
            list.notifyAll();
            return message;
        }
    }

    private void put(Message message) {
        synchronized (list) {
            while (list.size() == capcity) {
                log.info("队里已满");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            log.info("已生产 message:{}", message);
            list.addLast(message);
            list.notifyAll();
        }
    }

    public static void main(String[] args) {
        int a = 0;
        Arrays.asList("a","b","c").stream().collect(Collectors.toList());
        MessageQueue messageQueue = new MessageQueue(2);
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                Message message = new Message(finalI, "message" + finalI);
                messageQueue.put(message);
            }).start();
        }

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Message message = messageQueue.get();
            }
        }).start();

    }

}

class Message {
    private Integer id;
    private String message;

    public Message(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", message='" + message + '\'' + '}';
    }
}
