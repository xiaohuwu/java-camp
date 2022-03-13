package com.mldn.mldnbootbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
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
        SpringApplication.run(MldnbootBaseApplication.class, args);
    }

}
