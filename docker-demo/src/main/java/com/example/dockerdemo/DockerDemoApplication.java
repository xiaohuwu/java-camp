package com.example.dockerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DockerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerDemoApplication.class, args);
    }

    @RequestMapping("/")
    public Map<String, Object> getUser() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangxing");
        map.put("age", 27);
        return map;
    }

}
