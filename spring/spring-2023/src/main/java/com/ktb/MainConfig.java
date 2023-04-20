package com.ktb;

import com.ktb.model.Person;
import org.springframework.context.annotation.*;


@ComponentScan(basePackages = "org.example.service")
public class MainConfig {

    @Bean(name = "person")
    @Lazy
    public Person getPerson() {
        return new Person("xiaohuge", 23);
    }


    @Bean("bill")
    @Conditional({LinuxCondition.class})
    public Person person01() {
        return new Person("Bill Gates", 62);
    }

    @Bean("linus")
    public Person person02() {
        return new Person("linus", 48);
    }


}
