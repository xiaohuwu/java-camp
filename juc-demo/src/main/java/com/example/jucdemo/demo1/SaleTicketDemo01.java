package com.example.jucdemo.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo01 {


    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                ticket.sale();
            }
        }, "A");

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) {
                ticket.sale();
            }
        }, "B");

        thread1.start();
        thread2.start();
        try {
            // 等待两个线程都运行结束后，再打印结果
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //期待结果是20000，但是结果会小于这个值
        System.out.println(ticket.getNumber());

    }


}


class Ticket {
    private int number = 0;
//    方式 1
//    public synchronized void sale() {
//        number ++;
////        System.out.println("number:"+number);
//    }

    Lock lock = new ReentrantLock();

//
//    这是我自己的版本
//    public  void sale() {
//        lock.lock();
//        number ++;
//        lock.unlock();
//    }

    //老师的版本
    public void sale() {


//        number++;
        lock.lock();
        try {
            number++;
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}