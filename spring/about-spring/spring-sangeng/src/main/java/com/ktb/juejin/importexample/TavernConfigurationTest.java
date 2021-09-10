package com.ktb.juejin.importexample;


import com.ktb.juejin.importexample.model.Bartender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.stream.Stream;

//@Import 注解 示例
public class TavernConfigurationTest {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TavernConfiguration.class);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.register(TavernConfiguration.class);
        ctx.refresh();
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
        System.out.println("--------------------------");
        Map<String, Bartender> bartenders = ctx.getBeansOfType(Bartender.class);
        bartenders.forEach((name, bartender) -> System.out.println(bartender));
    }
}
