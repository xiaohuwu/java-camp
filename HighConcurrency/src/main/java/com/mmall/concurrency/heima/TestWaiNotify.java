package com.mmall.concurrency.heima;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestWaiNotify {
   static Object object = new Object();
    public static void main(String[] args) {

        new Thread(()->{
            synchronized (object){
                try {
                    log.info("before wait");
                    object.wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("其他线程开始执行");

            }
        },"t1").start();

        new Thread(()->{
            synchronized (object){
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("其他线程开始执行");
            }
        },"t2").start();

//        try {
//            Thread.sleep(3000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


//        synchronized (object){
//            object.notifyAll();
//        }

    }




}
