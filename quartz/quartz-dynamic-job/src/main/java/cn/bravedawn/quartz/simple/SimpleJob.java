package cn.bravedawn.quartz.simple;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author : depers
 * @program : quartz-dynamic-job
 * @date : Created in 2024/9/21 13:48
 */
@Slf4j
public class SimpleJob extends SimpleParentJob {


    @Override
    public void execute(JobDataMap jobDataMap) {
        log.info("开始执行具体的跑批任务");
        for (int i = 0; i < 100; i++) {
            log.info("执行运算逻辑, i={}", i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                new RuntimeException(e);
            }
        }
        log.info("具体的跑批任务执行结束");
    }
}
