package cn.bravedawn.springevents.asynchronous;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * @author : depers
 * @program : spring-core
 * @description:
 * @date : Created in 2021/12/27 21:45
 */
@Configuration
@ComponentScan({"cn.bravedawn.springevents.synchronous"})
public class AsynchronousSpringEventsConfig {

    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        final SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
        simpleApplicationEventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return simpleApplicationEventMulticaster;
    }



}
