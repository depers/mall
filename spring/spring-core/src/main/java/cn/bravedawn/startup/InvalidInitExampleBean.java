package cn.bravedawn.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : spring-core
 * @description:
 * @date : Created in 2023/1/5 16:34
 */

@Component
@Scope("prototype")
public class InvalidInitExampleBean {

    @Autowired
    private Environment environment;

    public InvalidInitExampleBean() {
        environment.getActiveProfiles();
    }

}
