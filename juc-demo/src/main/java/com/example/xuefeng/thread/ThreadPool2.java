package com.example.xuefeng.thread;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool2 {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
//        ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new Task("one-time"), 1, 2, TimeUnit.SECONDS);
//        ses.shutdown();
    }

}

@Slf4j
class Task implements Runnable {
    private String name;

    public Task(String s) {
        this.name = s;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = name + " run the task " + getString();
        log.info("s:{}", s);
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
