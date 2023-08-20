package cn.bravedawn.orm;

import java.lang.annotation.*;

/**
 * @author : depers
 * @program : jdbc-demo
 * @description:
 * @date : Created in 2023/2/24 07:53
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Param {

    String value() default "";
}
