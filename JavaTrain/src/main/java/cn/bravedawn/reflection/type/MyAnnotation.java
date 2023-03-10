package cn.bravedawn.reflection.type;

import java.lang.annotation.*;

/**
 * @author : depers
 * @program : mybatis
 * @description: 自定义注解
 * @date : Created in 2021/4/15 8:24
 */

@Target({ElementType.FIELD, ElementType.TYPE_USE, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    int value();
}
