package com.example.jucdemo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache <K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    /**
     * 传递进来最多能缓存多少数据
     *
     * @param capacity 缓存大小
     */
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    /**
     * 如果map中的数据量大于设定的最大容量，返回true，再新加入对象时删除最老的数据
     *
     * @param eldest 最老的数据项
     * @return true则移除最老的数据
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当 map中的数据量大于指定的缓存个数的时候，自动移除最老的数据
        return size() > capacity;
    }

    // 获取缓存中的值，如果不存在，返回null
    public V get(Object key) {
        return super.get(key);
    }

    // 将键值对放入缓存
    public V put(K key, V value) {
        return super.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(3);

        cache.put("one", 1);
        cache.put("two", 2);
        cache.put("three", 3);

        System.out.println(cache.get("one")); // 输出 1
        System.out.println(cache.get("two")); // 输出 2

        cache.put("four", 4); // 添加新元素，最老的元素（键为 "three"）将被删除

        System.out.println(cache.get("three")); // 输出 null，因为该元素已被删除
        System.out.println(cache.get("four")); // 输出 4
    }


}
