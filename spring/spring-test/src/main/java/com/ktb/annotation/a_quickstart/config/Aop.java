package com.ktb.annotation.a_quickstart.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//@Configuration
//@Aspect
public class Aop {

    //    用Pointcut注解中的属性来指定对哪些方法进行增强
    @Pointcut("@annotation(com.ktb.annotation.a_quickstart.config.InvokeLog)")
    public void pt() {
    }


    @Before("pt()")
    public void methodBefore(JoinPoint joinPoint) {
        System.out.println("方法被调用了");
        //输出 被增强的方法所在的类名 方法名 调用时传入的参数   joinPoint.getSignature().getName()  joinPoint.getArgs()
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //类名
        String className = signature.getDeclaringTypeName();
        //方法名
        String methodName = signature.getName();
        //调用时传入的参数
        Object[] args = joinPoint.getArgs();
        System.out.println(className + "==" + methodName + "======" + Arrays.toString(args));
    }


    @AfterReturning(value = "pt()", returning = "ret")//使用returning属性指定了把目标方法返回值赋值给下面方法的参数ret
    public void AfterReturning(JoinPoint jp, Object ret) {
        String ret1 = (String) ret;
        System.out.println("ret1 = " + ret1);
        System.out.println("AfterReturning方法被调用了");
    }




}
