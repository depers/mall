package cn.bravedawn.springevents.asynchronous;

import cn.bravedawn.springevents.synchronous.CustomSpringEventPublisher;
import cn.bravedawn.springevents.synchronous.SynchronousSpringEventsConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author : depers
 * @program : spring-core
 * @description:
 * @date : Created in 2021/12/27 21:51
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AsynchronousSpringEventsConfig.class}, loader = AnnotationConfigContextLoader.class)
public class AsynchronousCustomSpringEventsIntegrationTest {

    @Autowired
    private CustomSpringEventPublisher publisher;

    @Test
    public void testCustomSpringEvents() throws InterruptedException {
        publisher.publishCustomEvent("Hello world!!");
        System.out.println("Done publishing asynchronous custom event. ");
    }
}
