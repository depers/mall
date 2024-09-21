package cn.bravedawn.quartz.cron;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : quartz-dynamic-job
 * @date : Created in 2024/9/21 13:48
 */

@Slf4j
@Component("cronJob")
public class CronJob implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("开始执行具体的任务");
        for (int i = 0; i < 100; i++) {
            log.info("执行运行逻辑， i={}", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        log.info("具体的跑批任务执行结束");
    }
}
