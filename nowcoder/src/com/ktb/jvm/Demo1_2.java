package com.ktb.jvm;

public class Demo1_2 {
    public static int count = 0;

    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("count = " + count);
        }
    }

    private static void method1() {
        count++;
        method1();
    }
}
