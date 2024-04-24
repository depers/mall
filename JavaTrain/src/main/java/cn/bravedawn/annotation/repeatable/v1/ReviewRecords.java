package cn.bravedawn.annotation.repeatable.v1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : fengx9
 * @program : JavaTrain
 * @date : Created in 2023/03/01 1:09 PM
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ReviewRecords {


    ReviewRecord[] value();
}
