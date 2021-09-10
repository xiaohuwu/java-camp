package com.ktb;
import com.ktb.juejin.property.MainConfig;
import com.ktb.model.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Property {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.printf("bean:"+bean);
    }

}
