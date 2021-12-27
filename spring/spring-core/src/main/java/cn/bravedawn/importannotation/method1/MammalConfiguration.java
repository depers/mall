package cn.bravedawn.importannotation.method1;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : depers
 * @program : spring-core
 * @description:
 * @date : Created in 2021/11/26 7:36
 */

@Configuration
@Import({ DogConfig.class, CatConfig.class })
public class MammalConfiguration {
}
