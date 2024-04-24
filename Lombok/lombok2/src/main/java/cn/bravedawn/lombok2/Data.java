package cn.bravedawn.lombok2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author : fengx9
 * @Project : lombok2
 * @Date : Created in 2023-11-09 13:50
 */


@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface Data {

    /**
     * Data注解类
     */
}
