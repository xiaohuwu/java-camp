package com.example.jucdemo.basic;

public class RunableDemo {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("i am runnable");
        }
        ) {
            @Override
            public void run() {
                System.out.println("i am extend");
            }
        }.start();
    }

}
