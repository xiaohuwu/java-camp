package com.ktb.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    //切面类加入到容器中
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

}
