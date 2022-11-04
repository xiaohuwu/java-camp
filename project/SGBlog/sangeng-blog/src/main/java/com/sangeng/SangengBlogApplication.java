package com.sangeng;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sangeng.mapper")
@Slf4j
public class SangengBlogApplication implements ApplicationRunner {

    @Value("${spring.profiles.active}")
    private String profile;

    public static void main(String[] args) {
        SpringApplication.run(SangengBlogApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.setProperty("spring.profiles.active", profile);
        System.out.println("启动成功");
    }
}
