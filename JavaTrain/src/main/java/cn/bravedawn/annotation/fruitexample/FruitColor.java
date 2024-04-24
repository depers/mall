package cn.bravedawn.annotation.fruitexample;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    public enum Color{BLUE, RED, BLACK};

    Color fruitColor() default Color.BLUE;
}
