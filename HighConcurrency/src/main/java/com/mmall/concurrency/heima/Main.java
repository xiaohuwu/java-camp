package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.mmall.concurrency.heima.Sleeper.sleep;

@Slf4j
public class Main {
    static  boolean run = true;    //添加volatile

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (run) {

            }
        });
        t.start();
        sleep(1);
        run = false;
    }
}
