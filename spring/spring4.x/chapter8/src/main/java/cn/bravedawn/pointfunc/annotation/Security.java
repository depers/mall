package cn.bravedawn.pointfunc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/11 16:42
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Security {

    String value() default "";
}
