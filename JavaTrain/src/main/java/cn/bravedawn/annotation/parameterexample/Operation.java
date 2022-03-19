package cn.bravedawn.annotation.parameterexample;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Operation {

    String value() default "功能名称";

    String notes() default "功能说明";

}
