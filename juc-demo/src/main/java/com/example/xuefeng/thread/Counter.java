package com.example.xuefeng.thread;

public class Counter {
    private int count = 0;

    public synchronized void add(int n) {
        if (n < 0) {
            dec(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec(int n) {
        count += n;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

//    public static void main(String[] args) {
//        Counter1 counter = new Counter1();
//        counter.add(-3);
//        System.out.println("counter.getCount() = " + counter.getCount());
//    }



}
