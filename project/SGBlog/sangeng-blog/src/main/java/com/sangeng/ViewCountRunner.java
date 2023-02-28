package com.sangeng;

import com.sangeng.entity.Article;
import com.sangeng.mapper.ArticleMapper;
import com.sangeng.utils.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
@Slf4j
public class ViewCountRunner implements CommandLineRunner {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    RedisCache redisCache;

    @Autowired
    RedisProperties redisProperties;


    @Override
    public void run(String... args) throws Exception {
        log.info("redisProperties = " + redisProperties.getDatabase());
//        List<Article> articles = articleMapper.selectList(null);
//        Map<String, Integer> collect = articles.stream()
//                .collect(Collectors.toMap(item -> item.getId().toString(), item -> item.getViewCount().intValue()));
//
//        collect.entrySet().stream()
//                .forEach(e -> System.out.println("before:" + e.getKey() + ":" + e.getValue()));
//
//        redisCache.setCacheMap("article:viewCount1", collect);
//
//        Map<String, Integer> cacheMap = redisCache.getCacheMap("article:viewCount1");
//        cacheMap.entrySet().stream()
//                .forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
    }
}
