package org.example.basic_di.c_value_spel;
import org.example.basic_di.c_value_spel.bean.Blue;
import org.example.basic_di.c_value_spel.bean.Green;
import org.example.basic_di.c_value_spel.bean.Red;
import org.example.basic_di.c_value_spel.config.InjectValueConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectValueAnnoApplication {


    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(InjectValueConfiguration.class);
        Red black = ctx.getBean(Red.class);
        System.out.println("simple value : " + black);

        Blue bean = ctx.getBean(Blue.class);
        System.out.println("bean = " + bean);

        Green green = ctx.getBean(Green.class);
        System.out.println("green = " + green);

    }
}