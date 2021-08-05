package com.example.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: YongQiang.Li
 * 3 * @Date: 2021/7/30 14:58
 * 4
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 普通获取缓存
     * @param key
     * @return
     */
    public String get(String key) {
        return key == null ? null : (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * 缓存set值：可重复set
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 如果key已存在，则返回false
     * @param key
     * @param value
     * @return
     */
    public boolean setNx(String key, Object value) {
        try {
            return redisTemplate.opsForValue().setIfAbsent(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 缓存删除
     * @param key
     * @return
     */
    public boolean del(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
