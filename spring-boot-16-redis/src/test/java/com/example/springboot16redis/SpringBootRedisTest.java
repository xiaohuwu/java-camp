package com.example.springboot16redis;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class SpringBootRedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1(){
        redisTemplate.opsForValue().set("name","gege");
    }


    @Test
    public void test2(){
        redisTemplate.opsForValue().get("name");
    }

    @Test
    public void test3(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("info","b","bb");
    }

    @Test
    public void test4(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        String s = (String) hashOperations.get("info", "b");
        System.out.println("s = " + s);
    }

}
