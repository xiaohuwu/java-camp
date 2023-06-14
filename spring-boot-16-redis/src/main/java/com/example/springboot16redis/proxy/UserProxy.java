package com.example.springboot16redis.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserProxy implements InvocationHandler {

    private Object target;

    public UserProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object res = method.invoke(target, args);

        System.out.println("记录日志");

        return res;
    }
}
