package com.ktb.mutithread;

public class MyUserContext implements AutoCloseable {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public MyUserContext(String message) {
        threadLocal.set(message);
    }

    public String get() {
        return threadLocal.get();
    }

    @Override
    public void close() {
        System.out.println("remove is call");
        threadLocal.remove();
    }
}
