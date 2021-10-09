package cn.bravedawn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : depers
 * @program : mall
 * @description: 幂等性校验
 * @date : Created in 2021/10/9 21:55
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface CheckIdempotent {
}
