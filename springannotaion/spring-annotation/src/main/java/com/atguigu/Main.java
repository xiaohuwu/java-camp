package com.atguigu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface MyInterface {
    void publicMethod();
}

class MyClass implements MyInterface {
    public void publicMethod() {
        System.out.println("Public Method Called");
        privateMethod();
    }

    private void privateMethod() {
        System.out.println("Private Method Called");
    }
}

public class Main {
    public static void main(String[] args) {
        MyInterface original = new MyClass();
        MyInterface proxyInstance = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[] { MyInterface.class },
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Before method: " + method.getName());
                        Object result = method.invoke(original, args);
                        System.out.println("After method: " + method.getName());
                        return result;
                    }
                });

        proxyInstance.publicMethod();  // 将会触发代理逻辑以及调用 publicMethod 和 privateMethod
    }
}
