package com.example.jucdemo.basic;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadSafe1 {
    public static void main(String[] args) throws InterruptedException {
        Number number = new Number();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
             log.info("begin");
                try {
                    number.a();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("begin");
                try {
                    number.b();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

    }
}

@Slf4j
class Number{
    public synchronized void a() throws InterruptedException {
//        Thread.sleep(1000);
        String s = "1";
        log.info("s:{}", s);
    }

    public synchronized void b() throws InterruptedException {
        String s = "2";
        log.info("s:{}", s);
    }
}
