package com.example.springboothello;

import com.example.springboothello.mapper.UserMapper;
import com.example.springboothello.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.concurrent.CompletableFuture;

@Slf4j
@SpringBootTest
class SpringBootHelloApplicationTests {


    @Autowired
    UserMapper userMapper;
    @Autowired
    AsyncTasks asyncTasks;

    @Autowired
    private Environment env;


    @Test
    void contextLoads() {
//        int value = userMapper.insert("xiaohugege", 1);
//        System.out.println("value = " + value);
//        User xiaohugege = userMapper.findByName("xiaohugege");
//        System.out.println("xiaohugege = " + xiaohugege);

        String property = env.getProperty("swagger.title");
        System.out.println("property = " + property);
    }


    @Test
    void Test2() throws Exception {
        long start = System.currentTimeMillis();
        CompletableFuture task1 = asyncTasks.doTaskOne();
        CompletableFuture task2 = asyncTasks.doTaskTwo();
        CompletableFuture task3 = asyncTasks.doTaskThree();
        CompletableFuture.allOf(task1, task2, task3).join();
        long end = System.currentTimeMillis();
        log.info("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }


}
