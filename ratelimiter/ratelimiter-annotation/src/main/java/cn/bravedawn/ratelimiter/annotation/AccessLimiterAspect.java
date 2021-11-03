package cn.bravedawn.ratelimiter.annotation;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author : depers
 * @program : ratelimiter
 * @description: AccessLimiter切面
 * @date : Created in 2021/11/3 22:48
 */

@Aspect
@Slf4j
@Component
public class AccessLimiterAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisScript<Boolean> redisScriptLua;

    @Pointcut("@annotation(cn.bravedawn.ratelimiter.annotation.AccessLimiter)")
    public void cut() {
        log.info("cut");
    }


    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        // 1. 获取方法签名，作为method key
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        AccessLimiter annotation = method.getAnnotation(AccessLimiter.class);
        if (annotation == null) {
            return;
        }

        String key = annotation.methodKey();
        Integer limit = annotation.limit();
        // 如果没设置methodkey, 从调用方法签名生成自动一个key
        if (!StringUtils.hasText(key)) {
            Class[] type = method.getParameterTypes();
            key = method.getClass() + method.getName();

            String paramTypes = Arrays.stream(type)
                    .map(Class::getName)
                    .collect(Collectors.joining(","));
            key += "#" + paramTypes;
            log.info("key: {}", key);
        }

        // 2. 调用Redis
        Boolean acquired = stringRedisTemplate.execute(
                redisScriptLua, // Lua script的真身
                Lists.newArrayList(key), // Lua脚本中的Key列表
                limit.toString() // Lua脚本Value列表
        );

        if (Boolean.FALSE.equals(acquired)) {
            log.error("your access is blocked, key={}", key);
            throw new RuntimeException("Your access is blocked");
        }
    }

}

