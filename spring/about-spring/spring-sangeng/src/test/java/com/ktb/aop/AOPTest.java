package com.ktb.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        MathCalculator calculator = applicationContext.getBean(MathCalculator.class);
        System.out.println(calculator.div(10, 2));

        applicationContext.close();

    }
}
