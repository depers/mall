package cn.bravedawn.ratelimiter;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

/**
 * @author : depers
 * @program : ratelimiter
 * @description: 访问限流
 * @date : Created in 2021/11/3 7:29
 */

@Service
@Slf4j
@Deprecated
public class AccessLimiter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisScript<Boolean> redisScriptLua;


    public void limitAccess(String key, Integer limit) {
        // step1: request Lua script
        Boolean acquired = stringRedisTemplate.execute(redisScriptLua, Lists.newArrayList(key), limit.toString());

        if (Boolean.FALSE.equals(acquired)) {
            log.error("Your access is blocked, key={}", key);
            throw new RuntimeException("Your access is blocked");
        }
    }
}
