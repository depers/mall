package cn.bravedawn.quartz.crontrigger;

import cn.bravedawn.quartz.common.ScheduleUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author : depers
 * @program : spring-quartz-demo
 * @date : Created in 2024/8/5 15:18
 */
@Component
@Slf4j
public class CronTriggerScheduleUtils {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private ScheduleUtils scheduleUtils;

    public void addCronJob(String jobName, String jobGroup, String cronExpression, Map<String, Object> params) throws SchedulerException {

        if (scheduleUtils.isExistJob(jobName, jobGroup)) {
            log.error("批量作业已存在，jobName={}", jobName);
            throw new RuntimeException("批量任务已存在");
        }

        JobDetail jobDetail = JobBuilder
                .newJob(CronJob.class)
                .storeDurably(true)
                // 如果执行失败，是否支持恢复
                .requestRecovery(true)
                .withIdentity(jobName, jobGroup)
                .build();

        if (params != null && !params.isEmpty()) {
            jobDetail.getJobDataMap().putAll(params);
        }

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(jobName, jobGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))  // 每30分钟执行一次
                .build();

        log.info("cron默认的错过策略是：{}", trigger.getMisfireInstruction());

        // 将JobDetail和CronTrigger注册到调度器
        scheduler.scheduleJob(jobDetail, trigger);

        // 让调度器运行
        scheduler.start();

    }
}
