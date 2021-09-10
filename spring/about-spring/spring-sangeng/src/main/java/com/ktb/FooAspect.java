package com.ktb;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
class FooAspect {
    @Before("execution(public void foo())")
    public void method() {
        System.out.println("before");
    }
}
