package cn.bravedawn.annotation.repeatable;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(RepeatAnnotations.class)
public @interface RepeatAnnotation {
}
