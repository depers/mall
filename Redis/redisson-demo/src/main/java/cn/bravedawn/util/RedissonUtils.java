package cn.bravedawn.util;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : redisson-demo
 * @date : Created in 2024/4/29 20:07
 */

@Component
public class   RedissonUtils {


    /**
     * 工具类
     */

    @Autowired
    private RedissonClient redissonClient;

    public String get(String key) {
        RBucket<String> bucket = redissonClient.getBucket(key);
        return bucket.get();
    }
}
