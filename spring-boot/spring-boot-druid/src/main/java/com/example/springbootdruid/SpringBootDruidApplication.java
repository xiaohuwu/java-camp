package com.example.springbootdruid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDruidApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootDruidApplication.class, args);
        ClientService clientService = run.getBean(ClientService.class);
        int add = clientService.add(1, 2);
        System.out.println("add = " + add);
    }


}
