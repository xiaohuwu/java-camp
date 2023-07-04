package com.ktb.design_pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;


    public ProxyInvocationHandler() {
    }

    //得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    public void log(String s) {
        System.out.println("[debug]:" + s);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(Arrays.toString(args));
        Object invoke = method.invoke(target, args);
        return invoke;
    }

    public void setTarget(UserServiceImpl userService) {
        this.target = userService;
    }

}
