package cn.bravedawn.annotation.fruitexample;


import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Fruit {

    // 水果名称
    String name();
}
