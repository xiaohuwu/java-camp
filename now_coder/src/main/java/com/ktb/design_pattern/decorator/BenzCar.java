package com.ktb.design_pattern.decorator;

public class BenzCar implements Car{
    @Override
    public void run() {
        System.out.println("奔驰开车了！");
    }
}
