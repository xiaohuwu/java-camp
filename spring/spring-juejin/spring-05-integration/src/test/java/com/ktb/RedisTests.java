package com.ktb;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:data/spring-data-jpa.xml")
public class RedisTests {

    @Autowired
    RedisTemplate redisTemplate;


    @Test
    public void testInsert() {
        // 向Redis存入一个key-value
        redisTemplate.opsForValue().set("name", "I am redis ...");
        // 向Redis存入一个key-list有序列表
        redisTemplate.opsForList().rightPushAll("list", "a", "b", "c");
    }



    @Test
    public void testGet() {
        System.out.println(redisTemplate.opsForValue().get("name"));
        System.out.println(redisTemplate.opsForList().index("list", 1));
    }
}
