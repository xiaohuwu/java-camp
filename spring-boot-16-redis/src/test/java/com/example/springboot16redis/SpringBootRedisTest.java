package com.example.springboot16redis;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class SpringBootRedisTest {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test1() {
        redisTemplate.opsForValue().set("name", "gege");
    }


    @Test
    public void test2() {
        redisTemplate.opsForValue().get("name");
    }

    @Test
    public void test3() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("info", "b", "bb");
    }

    @Test
    public void test4() {
        HashOperations hashOperations = redisTemplate.opsForHash();
        String s = (String) hashOperations.get("info", "b");
        System.out.println("s = " + s);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test5() {
        redisTemplate.getConnectionFactory();
        Class<? extends CacheManager> aClass = cacheManager.getClass();
        System.out.println("aClass = " + aClass);
        User u1 = userRepository.findByName("xiaohu");
        System.out.println("第一次查询：" + u1.getEmail());
        User gegeg = userRepository.findByName("xiaohu");
        System.out.println("gegeg.getName() = " + gegeg.getName());
    }

    @Test
//    @Transactional
    public void test6() {
        userRepository.save(new User("AAA", "120"));
        userRepository.save(new User("HHHHHHHHHH", "11"));
    }


}
