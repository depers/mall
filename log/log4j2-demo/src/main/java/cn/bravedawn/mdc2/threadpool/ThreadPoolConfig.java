package cn.bravedawn.mdc2.threadpool;

import com.alibaba.ttl.threadpool.TtlExecutors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.support.ExecutorServiceAdapter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author : depers
 * @program : log4j2-demo
 * @date : Created in 2024/8/6 17:28
 */

@Configuration
public class ThreadPoolConfig {

    @Bean
    public ExecutorService executorService() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(2);
        //配置最大线程数
        executor.setMaxPoolSize(5);
        //配置队列大小
        executor.setQueueCapacity(0);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("async-service-");

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();

        ExecutorServiceAdapter executorAdapter = new ExecutorServiceAdapter(executor);
        //使用TransmittableThreadLocal提供的包装池
        return TtlExecutors.getTtlExecutorService(executorAdapter);
    }
}
