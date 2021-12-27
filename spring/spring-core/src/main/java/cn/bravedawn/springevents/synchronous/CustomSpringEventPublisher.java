package cn.bravedawn.springevents.synchronous;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : spring-core
 * @description: 自定义spring事件发布者
 * @date : Created in 2021/12/27 21:26
 */

@Component
public class CustomSpringEventPublisher {

    private final Logger log = LogManager.getLogger(CustomSpringEventPublisher.class);

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    public void publishCustomEvent(final String message) {
        log.info("Publish custom event.");
        final CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}
