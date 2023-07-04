package com.ktb.design_pattern.decorator;

public class AutoCarDecorator{
    protected Car decoratedCar;
    public AutoCarDecorator(Car decoratedCar){
        this.decoratedCar = decoratedCar;
    }
    public void run(){
        decoratedCar.run();
        autoRun();
    }
    private void autoRun(){
        System.out.println("开启自动驾驶");
    }
}
