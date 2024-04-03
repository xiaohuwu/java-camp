package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test25 {
    private static boolean flag = false;
    private static Object object = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                synchronized (object){
                    while (flag){
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    log.info("1");
                    flag = !flag;
                    object.notifyAll();
                }
            }
        },"t1").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                synchronized (object){
                    while (!flag){
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    log.info("2");
                    flag = !flag;
                    object.notifyAll();
                }
            }
        },"t2").start();
    }
}
