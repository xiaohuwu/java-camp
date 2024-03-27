package com.ktb.muke;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;

class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        TimerThread timerThread = new TimerThread();
//        Class<? extends TimerThread> aClass = timerThread.getClass();
//        if (aClass.equals(TimerThread.class)) {
//            System.out.println("true = " + true);
//        }else {
//            System.out.println("false = " + false);
//        }

        try (InputStream input = TimerThread.class.getResourceAsStream("log4j.properties")) {
            if (input != null) {
                System.out.println(input);
            }else {
                System.out.println("empty");
            }
        }
    }
}
