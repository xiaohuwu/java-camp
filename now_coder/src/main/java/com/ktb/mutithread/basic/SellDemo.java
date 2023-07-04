package com.ktb.mutithread.basic;

import java.util.List;
import java.util.Random;
import java.util.Vector;


public class SellDemo {
    public static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        TickWindow window = new TickWindow(1000);
        List<Thread> threads = new Vector<>();
        List<Integer> amountList = new Vector<>();
        for (int i = 0; i < 4000; i++) {
            Thread thread = new Thread(() -> {
                int sell = window.sell(random.nextInt(5));
                amountList.add(sell);
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        int sum = amountList.stream().mapToInt((i) -> i).sum();
        System.out.println("window.getBalance() = " + window.getBalance());
        System.out.println("sum = " + sum);
    }


    static class TickWindow {

        public int balance;

        public TickWindow(int i) {
            this.balance = i;
        }

        public int getBalance() {
            return balance;
        }

        public  int sell(int count) {
            if (balance >= count) {
                balance -= count;
                return count;
            } else {
                return 0;
            }
        }
    }
}
