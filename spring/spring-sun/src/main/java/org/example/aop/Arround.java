package org.example.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Arround implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation MethodInterceptor) throws Throwable {
        System.out.println("before log -----------");
        Object proceed = MethodInterceptor.proceed();
        System.out.println("after log  -----------");
        return proceed;
    }
}
