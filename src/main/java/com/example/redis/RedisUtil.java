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

    public boolean set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
