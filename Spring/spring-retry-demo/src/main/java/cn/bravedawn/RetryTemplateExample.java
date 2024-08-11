package cn.bravedawn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : spring-retry-demo
 * @date : Created in 2024/8/11 12:28
 */
@Component
@Slf4j
public class RetryTemplateExample implements ApplicationRunner {

    @Autowired
    private RetryTemplate retryTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            retryTemplate.execute(new RetryCallback() {
                @Override
                public Object doWithRetry(RetryContext context) throws Throwable {

                    log.info("开始数据计算");
                    int i = 1 / 0;
                    log.info("数据计算结束");
                    return null;
                }
            }, new RecoveryCallback<Object>() {
                @Override
                public Object recover(RetryContext retryContext) throws Exception {
                    int retryCount = retryContext.getRetryCount();
                    Throwable e = retryContext.getLastThrowable();
                    log.info("已经重试了{}次，最后一次失败的原因是：{}", retryCount, e.getMessage());
                    return null;
                }
            });
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
