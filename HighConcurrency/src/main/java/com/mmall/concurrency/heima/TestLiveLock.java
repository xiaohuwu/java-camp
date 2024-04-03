package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestLiveLock {
    static volatile int count = 10;

    public static void main(String[] args) {
        new Thread(()->{
            while (count > 0){
                Sleeper.sleep(1);
                count --;
                log.info("t1 count:{}", count);

            }
        },"t1").start();

        new Thread(()->{

            while (count < 100){
                Sleeper.sleep(1);
                count++;
                log.info("t2 count:{}", count);
            }
        },"t2").start();

    }

}
