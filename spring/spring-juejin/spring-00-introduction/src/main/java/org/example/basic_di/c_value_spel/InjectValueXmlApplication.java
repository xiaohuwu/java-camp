package org.example.basic_di.c_value_spel;
import org.example.basic_di.c_value_spel.bean.Blue;
import org.example.basic_di.c_value_spel.bean.Red;
import org.example.basic_di.c_value_spel.config.InjectValueConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectValueXmlApplication {


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basic_di/value/inject-value.xml");
        Red black = ctx.getBean(Red.class);
        System.out.println("simple value : " + black);


    }
}
