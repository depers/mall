package cn.bravedawn.springevents.synchronous;

import cn.bravedawn.importannotation.method1.MammalConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * @author : depers
 * @program : spring-core
 * @description: 自定义同步spring事件集成测试
 * @date : Created in 2021/12/27 21:36
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SynchronousSpringEventsConfig.class}, loader = AnnotationConfigContextLoader.class)
public class SynchronousCustomSpringEventsIntegrationTest {


    @Autowired
    private CustomSpringEventPublisher publisher;

    @Test
    public void testCustomSpringEvents() {
        publisher.publishCustomEvent("Hello world!!");
        System.out.println("Done publishing synchronous custom event. ");
    }

}
