package com.ktb.mutithread;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(4);
        Task task = new Task();
        Future submit = executors.submit(task);
        Object o = submit.get();
        System.out.println("o = " + o);
    }
}

class Task implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(1000);
        double d = 5 + Math.random() * 20;
        return new BigDecimal(d).setScale(2, RoundingMode.DOWN);
    }
}
