package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 买票问题
 */
@Slf4j
public class Sell {
    static Random random = new Random();

    public static int RandomAmount() {
        return random.nextInt(5) + 1;
    }

    static List<Integer> list = new CopyOnWriteArrayList<>();
    static ArrayList<Thread> threadArrayList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        TickWindow tickWindow = new TickWindow(10000);
        for (int i = 0; i < 2000; i++) {
            Thread thread = new Thread(() -> {
                int j = RandomAmount();
                int sell = tickWindow.sell(j);
                list.add(sell);
            });
            thread.start();
            threadArrayList.add(thread);

        }
        for (Thread thread : threadArrayList) {
            thread.join();
        }
        log.info("余票:{}", tickWindow.getCount());

        log.info("买出的票:{}", list.stream().mapToInt((item) -> item).sum());
    }
}

class TickWindow {
    private int count;

    public TickWindow(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int sell(int sell) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (count > sell) {
            count -= sell;
            return sell;
        } else {
            return 0;
        }

    }
}
