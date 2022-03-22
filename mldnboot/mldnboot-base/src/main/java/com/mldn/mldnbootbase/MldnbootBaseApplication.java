package com.mldn.mldnbootbase;

import com.mldn.mldnbootbase.config.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MldnbootBaseApplication {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MldnbootBaseApplication.class, args);
        User bean = run.getBean(User.class);
        System.out.println("bean = " + bean);
    }

}
