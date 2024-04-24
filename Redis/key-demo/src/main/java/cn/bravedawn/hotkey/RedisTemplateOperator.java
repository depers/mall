package cn.bravedawn.hotkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : key-demo
 * @date : Created in 2024/4/11 15:20
 */
@Component
public class RedisTemplateOperator {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private SlidingWindowsKeyCounter slidingWindowsKeyCounter;


    /**
     * 字符串set操作
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        slidingWindowsKeyCounter.countKey(key);
    }
}
