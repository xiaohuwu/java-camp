package com.ktb.design_pattern.status;

public class LightSwitch {
    private State state;

    public LightSwitch() {
        this.state = new OffState(); // initial state
    }

    public void setState(State state) {
        this.state = state;
    }

    public void toggle() {
        state.toggle(this);
    }
}
