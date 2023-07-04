package com.ktb.design_pattern.decorator;

public class FlyCarDecorator extends CarDecorator {
    public FlyCarDecorator(Car decoratedCar) {

        super(decoratedCar);
    }

    @Override
    public void run() {
        super.run();
        fly();
    }

    private void fly() {
        System.out.println("开启飞行汽车模式");
    }
}
