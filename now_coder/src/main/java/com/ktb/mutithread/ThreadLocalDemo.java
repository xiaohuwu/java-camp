package com.ktb.mutithread;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        try (var ctx = new MyUserContext("Bob")) {
            String s = ctx.get();
            System.out.println("s = " + s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (var ctx = new UserContext("hello")) {
            new Task1().process();
            new Task2().process();
            new Task3().process();
        }

    }
}
