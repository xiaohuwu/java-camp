package com.ktb.design_pattern.strategy;

public class DealContext {
    private String type;
    private DealStrategy deal;

    public DealContext(String type, DealStrategy deal) {
        this.type = type;
        this.deal = deal;
    }

    public String getType() {
        return type;
    }

    public DealStrategy getDeal() {
        return deal;
    }
}
