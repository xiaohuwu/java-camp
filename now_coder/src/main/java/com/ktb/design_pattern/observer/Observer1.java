package com.ktb.design_pattern.observer;

public class Observer1 implements Observer {

    @Override
    public void response(String message) {
        System.out.println("Observer1 action " + message);
    }
}
