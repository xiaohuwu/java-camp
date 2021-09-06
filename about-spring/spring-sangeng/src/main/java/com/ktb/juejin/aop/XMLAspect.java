package com.ktb.juejin.aop;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

//基于XML方式AOP调用方式
@Component("xmlAspect")
public class XMLAspect {

    //@Pointcut("execution(* com.ktb.service.*.*(..))")

    public void pt() {
    }

    public void methodbefore() {
        System.out.println("方法被调用了");
    }

    public void AfterReturning(JoinPoint jp, Object ret1) {
        System.out.println("result:" + ret1);
        System.out.println("AfterReturning方法被调用了");
    }

    public void AfterThrowing(JoinPoint jp,Throwable t){
        System.out.println(t.getMessage());
        System.out.println("AfterThrowing 方法被调用了");
    }
    public void After(JoinPoint jp) {
        System.out.println("After方法被调用了");
    }

}
