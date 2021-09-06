package com.ktb;

import com.ktb.model.Foo;
import com.ktb.model.FooImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.ktb")
public class Example {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Example.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String item: beanDefinitionNames) {
            System.out.println(item);
        }
        Foo f = ctx.getBean(Foo.class); // throw exception here 默认走JDK代理，代理对象 不是 FooImpl 子类，这里将会报错
        f.foo();
    }
}
