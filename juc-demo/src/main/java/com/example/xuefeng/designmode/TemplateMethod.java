package com.example.xuefeng.designmode;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.HashMap;
import java.util.Map;

public class TemplateMethod {
    public static void main(String[] args) {
        LocalSetting localSetting = new LocalSetting();
        String foo = localSetting.getSetting("foo");
        System.out.println("foo = " + foo);


        RedisSetting redisSetting = new RedisSetting();
        foo = redisSetting.getSetting("foo");
        System.out.println("foo = " + foo);
    }
}


class LocalSetting extends AbstractSetting {
    private Map<String, String> cache = new HashMap<>();

    @Override
    protected void putIntoCache(String key, String value) {
        cache.put(key, value);
    }

    @Override
    protected String lookupCache(String key) {
        return cache.get(key);
    }
}

class RedisSetting extends AbstractSetting {
    private RedisClient client = RedisClient.create("redis://localhost:6379");

    @Override
    protected void putIntoCache(String key, String value) {
        try (StatefulRedisConnection<String, String> connection = client.connect()) {
            RedisCommands<String, String> commands = connection.sync();
            commands.set(key, value);
        }
    }

    @Override
    protected String lookupCache(String key) {
        try (StatefulRedisConnection<String, String> connection = client.connect()) {
            RedisCommands<String, String> commands = connection.sync();
            return commands.get(key);
        }
    }
}

abstract class AbstractSetting {
    public final String getSetting(String key) {
        // 先从缓存读取:
        String value = lookupCache(key);
        if (value == null) {
            // 在缓存中未找到,从数据库读取:
            value = readFromDatabase(key);
            System.out.println("[DEBUG] load from db: " + key + " = " + value);
            // 放入缓存:
            putIntoCache(key, value);
        } else {
            System.out.println("[DEBUG] load from cache: " + key + " = " + value);
        }
        return value;
    }

    protected abstract void putIntoCache(String key, String value);

    protected abstract String lookupCache(String key);

    private String readFromDatabase(String key) {
        return Integer.toHexString(0x7fffffff & key.hashCode());
    }
}
