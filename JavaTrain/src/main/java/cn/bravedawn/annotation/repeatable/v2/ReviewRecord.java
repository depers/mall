package cn.bravedawn.annotation.repeatable.v2;

import java.lang.annotation.*;

/**
 * @author : fengx9
 * @program : JavaTrain
 * @date : Created in 2023/03/01 1:07 PM
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(ReviewRecords.class)
public @interface ReviewRecord {

    /**
     * 声明一个reviewRecord注解，用来描述代码审查的记录
     */

    String name();
    String date();
    String comment() default "";
}
