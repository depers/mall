package cn.bravedawn.orm.annotations;

import java.lang.annotation.*;

/**
 * @author : fengx9
 * @program : new-platform-main
 * @date : Created in 2023/03/01 1:23 PM
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Insert {

    String value();
}
