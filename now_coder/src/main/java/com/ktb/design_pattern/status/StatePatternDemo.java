package com.ktb.design_pattern.status;

public class StatePatternDemo {
    public static void main(String[] args) {
        LightSwitch lightSwitch = new LightSwitch();

        lightSwitch.toggle(); // Output: Light turned on.
        lightSwitch.toggle(); // Output: Light turned off.
    }
}
