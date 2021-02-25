package com.example.jucdemo.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "call Callable\n";
            }
        });
        new Thread(ft).start();
        System.out.println("waiting");
        System.out.printf(ft.get());
        System.out.println("I am down");
    }

}
