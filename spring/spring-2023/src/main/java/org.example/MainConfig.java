package org.example;

import org.example.model.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;


@ComponentScan(basePackages = "org.example.service")
public class MainConfig {

     @Bean(name="person")
     @Lazy
    public Person getPerson() {
        return new Person("xiaohuge", 23);
    }


}
