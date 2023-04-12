package com.example.jucdemo.basic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test5 {
    private static int r = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                r = 10;
            }
        });
        thread.start();
        thread.join(); //等待线程执行完成
        log.info("r:{}", r);
    }
}
