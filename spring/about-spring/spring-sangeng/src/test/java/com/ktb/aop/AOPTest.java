package com.ktb.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class AOPTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        String beanName = null;
        MathCalculator calculator = applicationContext.getBean(MathCalculator.class);
        int div = calculator.div(10, 2);
        System.out.println(div);

        applicationContext.close();

    }
}
