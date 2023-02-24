package cn.bravedawn.annotation.fruitexample;

import java.lang.annotation.*;


/**
 * 用户标明查询参数的名称
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {


    /**
     * 查询的字段名称
     * @return
     */
    String value() default "";
}
