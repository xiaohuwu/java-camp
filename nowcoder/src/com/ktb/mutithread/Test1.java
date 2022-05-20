package com.ktb.mutithread;

import java.util.concurrent.atomic.AtomicInteger;

public class Test1 {


    private static AtomicInteger var;

    public int incrementAndGet(AtomicInteger var) {
        int prev, next;
        do {
            prev = var.get();
            next = prev + 1;
        } while ( !var.compareAndSet(prev, next));
        return next;
    }

    public static void main(String[] args) {
        var = new AtomicInteger(3);
        System.out.println("var.incrementAndGet() = " + var.incrementAndGet());
    }
}
