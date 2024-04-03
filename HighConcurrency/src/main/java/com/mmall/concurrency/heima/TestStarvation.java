package com.mmall.concurrency.heima;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.*;

@Slf4j
public class TestStarvation {
    static Random random = new Random();
    static public String[] MENU = {"红烧茄子", "糖醋里脊", "豆腐", "番茄"};

    static String cooking() {
        return MENU[random.nextInt(MENU.length)];
    }
    public static void main(String[] args) {
        ExecutorService wait = Executors.newFixedThreadPool(1);
        ExecutorService cook = Executors.newFixedThreadPool(1);

        wait.submit(() -> {
            log.info("处理点餐。。。。");
            Future<String> result = cook.submit(() -> {
                log.info("做菜");
               return cooking();
            });
            String s = null;
            try {
                s = result.get();
                log.info("上菜：{}", s);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });


        wait.submit(() -> {
            log.info("处理点餐。。。。");
            Future<String> result = cook.submit(() -> {
                log.info("做菜");
                return cooking();
            });
            String s = null;
            try {
                s = result.get();
                log.info("上菜：{}", s);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });


    }
}
