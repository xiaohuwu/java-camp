package com.ktb;

import com.ktb.juejin.aop.Blue;
import com.ktb.juejin.aop.MainConfigOfAOP;
import com.ktb.juejin.aop.MathCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_AOP {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        applicationContext.publishEvent(new ApplicationEvent("我发布的事件"){
        });
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        //1、不要自己创建对象
//		MathCalculator mathCalculator = new MathCalculator();
//		mathCalculator.div(1, 1);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        Blue bean = applicationContext.getBean(Blue.class);
        mathCalculator.div(1, 1);

        applicationContext.close();
    }
}
