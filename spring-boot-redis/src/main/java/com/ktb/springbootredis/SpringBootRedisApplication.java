package com.ktb.springbootredis;

import com.ktb.springbootredis.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

/**
 * 此项目还包括shiro xml等
 */
@RestController
@EnableCaching
@SpringBootApplication
@MapperScan(value = {"com.ktb.springbootredis.mapper", "com.ktb.springbootredis.dao"})
public class SpringBootRedisApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisApplication.class, args);
    }

    // 缓存结果key：addUser::KeyGenerator:addUser
    @Cacheable(value = "addUser", keyGenerator = "oneKeyGenerator")
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        System.out.println("addUser==============>");
        return user;
    }

    @PostMapping("/getUser")
    @Cacheable(value = "user", key = "'id:'+#user.id")
    public User getUser(@RequestBody User user) {
        System.out.println("用户对象缓存不存在，返回一个新的用户对象。");
        return user;
    }

    @PostMapping("/updateUser")
    @CachePut(value = "user", key = "'id:'+#user.id")
    public User updateUser(@RequestBody User user) {
        System.out.println("用户对象缓存不存在，返回一个新的用户对象。");
        return user;
    }

    @GetMapping("/delUser")
    @CacheEvict(value = "user", key = "'id:'+ #p0")
    public String delUser(Integer id) {
        System.out.println("用户对象缓存不存在，返回一个新的用户对象。");
        return "ok";
    }


    @Bean("oneKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }


}
