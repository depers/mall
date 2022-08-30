package cn.bravedawn.importannotation.method2;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import({LoinConfig.class})
public class ImportSelectorConfiguration {


    @Bean
    public Horse horse() {
        return new Horse();
    }
}
