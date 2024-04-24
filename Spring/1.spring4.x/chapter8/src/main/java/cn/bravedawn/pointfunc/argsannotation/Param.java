package cn.bravedawn.pointfunc.argsannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : depers
 * @program : chapter8
 * @description:
 * @date : Created in 2023/7/13 17:34
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {

    String value() default "";
}
