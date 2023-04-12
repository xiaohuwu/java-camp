package com.example.jucdemo.basic;

public class TestFrame {
    public static void main(String[] args) {
        new Thread("t1"){
            @Override
            public void run() {
                method1(20);
            }
        }.start();
        method1(10);
    }

    private static void method1(int x){
        int y = x +1 ;
        Object m = method2();
    }

    private static Object method2() {
        return new Object();
    }

}
