package cn.bravedawn.annotation.parameterexample;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ParameterType {

    String type() default "string";

}
