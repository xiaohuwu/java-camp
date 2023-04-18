package com.example.jucdemo.basic;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

//三个线程顺序打印 abcabcabc
@Slf4j
public class Test6 {
    public static int publicFlag = 1;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                print("a", 1, 2, 10);
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                print("b", 2, 3, 10);
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                print("c", 3, 1, 10);

            }
        }).start();
    }


    public synchronized static void print(String content, Integer flag, Integer nextFlag, int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            while (publicFlag != flag) {
                Test6.class.wait();
            }
            log.info(content);
            publicFlag = nextFlag;
            Test6.class.notifyAll();
        }
    }

//    static class notification {
//        public synchronized void print(String content, Integer flag, Integer nextFlag, int count) throws InterruptedException {
//            for (int i = 0; i < count; i++) {
//                while (publicFlag != flag) {
//                    this.wait();
//                }
//                log.info(content);
//                publicFlag = nextFlag;
//                this.notifyAll();
//            }
//        }
//    }

}
