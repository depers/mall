package cn.bravedawn.importannotation.method2;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


/**
 * @author : depers
 * @program : spring-core
 * @description: @Import注解的使用方法二：ImportSelector方式
 * @date : Created in 2021/12/8 7:15
 */

public class LoinConfig implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {"cn.bravedawn.importannotation.animal.Loin",
                             "cn.bravedawn.importannotation.animal.Bug"};
    }
}
