package com.ktb.design_pattern.status;

public class OffState implements State {

    @Override
    public void toggle(LightSwitch lightSwitch) {
        System.out.println("Light turned on.");
        lightSwitch.setState(new OnState());
    }
}
