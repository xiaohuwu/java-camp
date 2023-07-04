package com.ktb.design_pattern.chain;

public class Test {
    public static void main(String[] args) {
        Handler handler = new Handler1();
        Handler handler2 = new Handler2();
        handler.setNext(handler2);
        handler.handleRequest(5);
        handler.handleRequest(10);
        handler.handleRequest(30);
    }
}
