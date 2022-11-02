package com;


import com.sangeng.SangengBlogApplication;
import com.sangeng.utils.RedisCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest(classes= SangengBlogApplication.class)
//@SpringBootTest
class SangengBlogApplicationTests {


    @Autowired
    RedisCache redisCache;

    @Test
    void contextLoads() {
        Map<String, Integer> cacheMap = redisCache.getCacheMap("article:viewCount1");
        cacheMap.entrySet().stream()
                .forEach(e -> System.out.println("gege---->:"+e.getKey() + ":" + e.getValue()));
    }

}
