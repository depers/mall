package cn.bravedawn.annotation.fruitexample;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {


    String value() default "";
}
