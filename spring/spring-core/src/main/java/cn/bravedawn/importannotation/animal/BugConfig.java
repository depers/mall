package cn.bravedawn.importannotation.animal;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : depers
 * @program : spring-core
 * @description:
 * @date : Created in 2021/11/26 7:18
 */
@Configuration
@Import(Bug.class)
public class BugConfig {
}
