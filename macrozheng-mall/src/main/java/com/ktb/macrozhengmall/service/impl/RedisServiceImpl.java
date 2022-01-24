package com.ktb.macrozhengmall.service.impl;

import com.ktb.macrozhengmall.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;

public class RedisServiceImpl implements RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        ArrayList<Object> objects = new ArrayList<>();
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public boolean expire(String key, long expire) {
        return false;
    }

    @Override
    public void remove(String key) {

    }

    @Override
    public Long increment(String key, long delta) {
        return null;
    }
}
