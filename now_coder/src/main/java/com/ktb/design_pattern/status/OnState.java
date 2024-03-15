package com.ktb.design_pattern.status;

public class OnState implements State{
    @Override
    public void toggle(LightSwitch lightSwitch) {
        System.out.println("Light turned off.");
        lightSwitch.setState(new OffState());
    }
}
