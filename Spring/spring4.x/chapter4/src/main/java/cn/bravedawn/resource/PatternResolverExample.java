package cn.bravedawn.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @author : depers
 * @program : 1.spring4.x
 * @description:
 * @date : Created in 2023/9/11 20:22
 */
public class PatternResolverExample {

    /**
     * 资源加载器的使用
     */


    public static void main(String[] args) throws IOException {
        // 使用PathMatchingResourcePatternResolver资源加载器
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

        // 加载所有类包cn.bravedawn(及子包)下以.xml为后缀的资源
        Resource resources[] = resourcePatternResolver.getResources("classpath*:cn/bravedawn/**/*.xml");

        for (Resource resource : resources) {
            System.out.println(resource.getDescription());
        }
    }
}
