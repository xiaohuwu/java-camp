package com.ktb.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    List<Observer> list = new ArrayList<>();
    public void register(Observer observer ){
        list.add(observer);
    }

    public void notice(String message){
        for (Observer observer : list) {
            observer.response(message);
        }
    }

}
