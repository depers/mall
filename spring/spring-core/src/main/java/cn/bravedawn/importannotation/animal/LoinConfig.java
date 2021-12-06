package cn.bravedawn.importannotation.animal;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class LoinConfig implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {"cn.bravedawn.importannotation.animal.Loin",
                             "cn.bravedawn.importannotation.animal.Bug"};
    }
}
