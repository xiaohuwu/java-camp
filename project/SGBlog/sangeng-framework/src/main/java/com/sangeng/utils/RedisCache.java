package com.sangeng.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RedisCache {

    @Autowired
    RedisTemplate redisTemplate;

    public void incrementCacheMapValue(String key, String hKey, long v) {
        redisTemplate.boundHashOps(key).increment(hKey, v);
    }

    public void setCacheMap(String key, Map<String, Integer> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    public Map getCacheMap(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

}
