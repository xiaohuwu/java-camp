package com.ktb.annotation.a_quickstart.config;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyAspect {

    public void before() {
        System.out.println("MyAspect.before");
    }

    public void afterThrowing(JoinPoint jp, Throwable e) {
        System.out.println("MyAspect e:" + e);
    }


}
