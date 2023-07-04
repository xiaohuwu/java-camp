package com.ktb.design_pattern.decorator;

public class BmwCar implements Car{

    @Override
    public void run() {
        System.out.println("宝马开车了！");
    }
}
