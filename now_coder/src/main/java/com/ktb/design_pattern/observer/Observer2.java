package com.ktb.design_pattern.observer;

public class Observer2 implements Observer {
    @Override
    public void response(String message) {
        System.out.println("Observer2 action: " + message);
    }
}
