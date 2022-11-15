package com.ktb;

import com.ktb.dao.UserMapper;
import com.ktb.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class RedisTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test1() {
        String redisKey = "test:count";
        redisTemplate.opsForValue().set(redisKey, 12);
        Object o = redisTemplate.opsForValue().get(redisKey);
        System.out.println("o:" + o);

        System.out.println(redisTemplate.opsForValue().increment(redisKey));
        System.out.println("o:" + redisTemplate.opsForValue().get(redisKey));
        redisTemplate.opsForValue().decrement(redisKey);
        System.out.println("o after:" + redisTemplate.opsForValue().get(redisKey));
    }

    // 批量发送命令,节约网络开销.
    @Test
    public void testBoundOperations() {
        String redisKey = "test:count";
        BoundValueOperations operations = redisTemplate.boundValueOps(redisKey);
        operations.increment();
        operations.increment();
        operations.increment();
        operations.increment();
        operations.increment();
        System.out.println(operations.get());
    }


}
