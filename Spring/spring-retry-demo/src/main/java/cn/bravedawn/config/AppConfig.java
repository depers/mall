package cn.bravedawn.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @author : depers
 * @program : spring-retry-demo
 * @date : Created in 2024/8/11 12:11
 */

@Configuration
@EnableRetry
@Slf4j
public class AppConfig {


    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(2000l);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
        retryPolicy.setMaxAttempts(3);
        retryTemplate.setRetryPolicy(retryPolicy);

        retryTemplate.registerListener(new RetryListener() {

            /**
             * 在第一次重试之前调用，决定是否重试
             */
            @Override
            public <T, E extends Throwable> boolean open(RetryContext retryContext, RetryCallback<T, E> retryCallback) {
                log.info("开始重试");
                return true;
            }

            /**
             * 在最后一次重试结束时调用
             */
            @Override
            public <T, E extends Throwable> void close(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {
                log.info("重试结束");
            }


            /**
             * 每次重试失败后调用。
             */
            @Override
            public <T, E extends Throwable> void onError(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {
                log.info("重试失败");
            }
        });

        return retryTemplate;
    }
}
