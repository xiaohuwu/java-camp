package com.example.xuefeng.thread;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

@Slf4j
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2, 4,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        for (int i = 0; i < 6; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String formattedDate = getString();
                    log.info("start task: " + formattedDate);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    log.info("end task: " + formattedDate);
                }
            });
        }

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
