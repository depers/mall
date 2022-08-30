package cn.bravedawn.ratelimiter.annotation;

import java.lang.annotation.*;

/**
 * @author : depers
 * @program : ratelimiter
 * @description: 限流注解
 * @date : Created in 2021/11/3 22:46
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLimiter {

    String methodKey() default "";

    int limit();
}
