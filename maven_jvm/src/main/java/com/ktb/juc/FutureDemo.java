package com.ktb.juc;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> submit = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                long start = System.currentTimeMillis();
                while (true) {
                    Long current = System.currentTimeMillis();
                    if (current - start > 1000) {
                        return 1;
                    }
                }
            }
        });

        try {
            Integer o = submit.get();
            System.out.println("o = " + o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
