package cn.bravedawn.orm.annotations;

import java.lang.annotation.*;

/**
 * @author : fengx9
 * @program : new-platform-main
 * @date : Created in 2023/03/01 2:16 PM
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Options {

    boolean useGeneratedKeys() default false;

    String keyProperty() default "";
}
