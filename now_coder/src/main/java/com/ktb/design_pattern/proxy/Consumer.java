package com.ktb.design_pattern.proxy;

public class Consumer {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.add();
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        //设置代理对象
        handler.setTarget(userService);
        //生成代理类
        IUserService proxy = (IUserService)handler.getProxy();
        proxy.add();
    }
}
