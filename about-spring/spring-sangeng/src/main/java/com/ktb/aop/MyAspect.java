package com.ktb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
//@Aspect("myAspect")
public class MyAspect {

    //@Pointcut("execution(* com.ktb.service.*.*(..))")


    @Pointcut("@annotation(com.ktb.aop.InvokeLog)")
    public void pt() {
    }

    /*
        用@Before注解来指定该方法中是增强的代码，并且是在被增强方法执行前执行的
        @Before的属性写上加了@Pointcut注解的方法: 方法名()
    */
    @Before("pt()")
    public void methodbefore() {
        System.out.println("方法被调用了");
    }

    @AfterReturning(value = "pt()", returning = "ret1")//使用returning属性指定了把目标方法返回值赋值给下面方法的参数ret
    public void AfterReturning(JoinPoint jp, Object ret1) {
        System.out.println("result:" + ret1);
        System.out.println("AfterReturning方法被调用了");
    }


    @AfterThrowing(value = "pt()",throwing = "t")//使用throwing属性指定了把出现的异常对象赋值给下面方法的参数t
    public void AfterThrowing(JoinPoint jp,Throwable t){
        System.out.println(t.getMessage());
        System.out.println("AfterThrowing 方法被调用了");
    }


    @After(value = "pt()")//使用returning属性指定了把目标方法返回值赋值给下面方法的参数ret
    public void After(JoinPoint jp) {
        System.out.println("After方法被调用了");
    }

}
