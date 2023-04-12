package com.example.jucdemo.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                Thread.sleep(3000);
//                log.info("call Callable =");
//                log.info("call Callable = " + "call Callable");
//                return "call Callable\n";
//            }
//        });
//        new Thread(ft).start();
//        log.info("waiting");
//        log.info("get:{}", ft.get());
//        log.info("I am down");

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String s = "i am running";
                    log.info("s:{}", s);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
