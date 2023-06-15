package com.ktb.juejin.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
/**
 *
 * 注册一个 AnnotationAwareAspectJAutoProxyCreator
 *
 *
 *
 */
@Configuration
public class MainConfigOfAOP {

    @Bean
    public MathCalculator mathCalculator(){
        return  new MathCalculator();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
