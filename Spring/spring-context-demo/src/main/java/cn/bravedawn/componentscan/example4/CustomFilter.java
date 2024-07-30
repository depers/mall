package cn.bravedawn.componentscan.example4;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author : depers
 * @program : spring-context-demo
 * @date : Created in 2024/7/22 15:52
 */
public class CustomFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        return metadataReader.getClassMetadata().getClassName().contains("cn.bravedawn.componentscan.service");
    }
}
