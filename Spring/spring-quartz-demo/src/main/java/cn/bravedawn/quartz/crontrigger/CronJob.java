package cn.bravedawn.quartz.crontrigger;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : spring-quartz-demo
 * @date : Created in 2024/8/5 15:45
 */

@DisallowConcurrentExecution
@Slf4j
public class CronJob implements Job {


    /**
     * 如果任务开始执行后会将任务信息存储在qrtz_fired_triggers表中
     * 项目启动时会查询是qrtz_fired_triggers中执行中断的任务，但是requestRecovery必须为true
     */


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("开始执行CronJob");
        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("CronJob执行结束");
    }
}
