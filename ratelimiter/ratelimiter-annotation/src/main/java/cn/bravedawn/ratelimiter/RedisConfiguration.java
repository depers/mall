package cn.bravedawn.ratelimiter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;

/**
 * @author : depers
 * @program : ratelimiter
 * @description: redis配置
 * @date : Created in 2021/11/3 21:38
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public DefaultRedisScript<Boolean> loadRedisScript() {
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript();
        redisScript.setLocation(new ClassPathResource("ratelimiter.lua"));
        redisScript.setResultType(Boolean.class);
        return redisScript;
    }
}
