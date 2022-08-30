package cn.bravedawn.springevents.synchronous;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : spring-core
 * @description: 自定义Spring事件监听器
 * @date : Created in 2021/12/27 21:29
 */

@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {

    private static final Logger log = LogManager.getLogger(CustomSpringEventListener.class);

    @Override
    public void onApplicationEvent(CustomSpringEvent event) {
        log.info("Received spring custom event - {}", event.getMessage());
    }
}
