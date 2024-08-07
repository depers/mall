package cn.bravedawn.importannotation.method1;

import cn.bravedawn.importannotation.animal.BirdConfig;
import cn.bravedawn.importannotation.method1.MammalConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ MammalConfiguration.class, BirdConfig.class})
public class AnimalConfiguration {
}
