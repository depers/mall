package cn.bravedawn.annotation.repeatable.v1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : fengx9
 * @program : JavaTrain
 * @date : Created in 2023/03/01 1:07 PM
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ReviewRecord {

    /**
     * 声明一个reviewRecord注解，用来描述代码审查的记录
     */

    String name();
    String date();
    String comment() default "";
}
