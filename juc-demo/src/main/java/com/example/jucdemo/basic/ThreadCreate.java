package com.example.jucdemo.basic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class ThreadCreate {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //方法1
        Thread thread = new Thread() {
            @Override
            public void run() {
                log.info("run test1");
            }
        };
        thread.start();

        //方法2
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("run test2");
            }
        }) {
            @Override
            public void run() {
                log.info("run test4");
            }
        }.start();

        //方法3
        Runnable runnable = () -> {
            log.info("run test3");
        };
        new Thread(runnable).start();

        //方法4
        FutureTask<String> futureTask = new FutureTask(() -> {
            return "hello world";
        });
        new Thread(futureTask).start();
        log.info("futureTask.get():{}", futureTask.get());

    }

}
