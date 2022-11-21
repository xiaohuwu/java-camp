package com.ktb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspects {
    //抽取公共的切入点表达式
    //本类引用 @Before("pointCut()")
    //其他类引用 @Before("com.zt.aop.LogAspects.pointCut()")
    @Pointcut("execution(public int com.ktb.aop.MathCalculator.*(..))")
    public void pointCut(){}

    //@Before在目标方法之前切入;切入点表达式（指定在哪个方法切入）
    @Before("pointCut()") //public int com.zt.aop.MathCalculator.div(int,int)
    public void logStart(JoinPoint joinPoint){ // JoinPoint 必须放在参数的第一位
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"运行...参数列表是：{"+ Arrays.asList(args) +"}");
    }
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"结束...");
    }
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result){
        System.out.println("除法正常返回...计算结果是：{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void logException(Exception e){
        System.out.println("除法异常...异常信息是：{"+e+"}");
    }
}
