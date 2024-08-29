package cn.bravedawn.quartz.simpletrigger;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author : depers
 * @program : spring-quartz
 * @date : Created in 2024/7/29 14:54
 */
@Slf4j
public class RealExecuteJob extends DynamicJob {


    @Override
    public void executeJob(Map<String, Object> jobDataMap) {
        log.info("执行具体的任务, jobDataMap={}", jobDataMap);
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("simple任务执行结束");
    }
}
