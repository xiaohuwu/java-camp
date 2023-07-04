package com.ktb.design_pattern.observer;

public class Test {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.register(new Observer1());
        subject.register(new Observer2());
        subject.notice("new message");
    }
}
