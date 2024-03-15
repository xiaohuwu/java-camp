package com.ktb.design_pattern.liaoxuefeng.adpter;

import java.util.concurrent.Callable;

public class RunnableAdapter implements Runnable{
    Callable callable;

    public RunnableAdapter(Callable callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
