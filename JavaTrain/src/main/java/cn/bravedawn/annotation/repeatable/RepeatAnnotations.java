package cn.bravedawn.annotation.repeatable;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RepeatAnnotations {


    RepeatAnnotation[] value();
}
