package com.example.xuefeng.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Slf4j
public class AccessLimitControl {
    // 任意时刻仅允许最多3个线程获取许可:
    final static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    String access = access();
                    log.info("access:{}", access + ":" + getString());
                }
            }).start();
        }
    }

    public static String access() throws Exception {
        // 如果超过了许可数量,其他线程将在此等待:
        boolean tryAcquire = semaphore.tryAcquire(3, TimeUnit.SECONDS);
        if (tryAcquire) {
            try {
                String formattedDate = getString();
                log.info("doing working:" + formattedDate);
                Thread.sleep(2000);
                return UUID.randomUUID().toString();
            } finally {
                semaphore.release();
            }
        }
        return null;
    }

    private static String getString() {
        Date currentDate = new Date();
        // 创建一个SimpleDateFormat对象，指定日期/时间格式
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 使用SimpleDateFormat对象的format()方法格式化Date对象
        String formattedDate = dateFormatter.format(currentDate);
        return formattedDate;
    }
}
