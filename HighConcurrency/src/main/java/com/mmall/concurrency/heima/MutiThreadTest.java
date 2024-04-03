package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MutiThreadTest {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("\"t1\" = " + "t1");
        },"t1").start();
        new Thread(()->{
            System.out.println("\"t2\" = " + "t2");
        },"t2").start();
        new Thread(()->{
            System.out.println("\"t3\" = " + "t3");
        },"t3").start();
        testForceReturn();
    }

    private static void testForceReturn(){
        int i = 0;
        log.info("接来了要写入数据库了，请三思:{}", "接来了要写入数据库了，请三思");
        writeDataBase();
    }

    private static void writeDataBase() {
        log.info("writeDataBase");
    }

}
