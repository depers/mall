package cn.bravedawn.quartz.simpletrigger;

import cn.bravedawn.quartz.common.ScheduleUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author : depers
 * @program : spring-quartz
 * @date : Created in 2024/7/26 14:18
 */

@Slf4j
@Component
public class SimpleTriggerScheduleUtils {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private ScheduleUtils scheduleUtils;


    /**
     * 添加简单任务
     * @param jobClass
     * @param jobName
     * @param jobGroup
     * @param desc
     * @param params
     * @param nextFireTime
     */
    public void addSimpleJob(Class<? extends Job> jobClass, String jobName, String jobGroup,
                             String desc, Map<String, Object> params, Date nextFireTime) {

        if (scheduleUtils.isExistJob(jobName, jobGroup)) {
            log.error("批量作业已存在，jobName={}", jobName);
            throw new RuntimeException("批量任务已存在");
        }

        JobDetail jobDetail = JobBuilder
                .newJob(jobClass)
                .storeDurably(true)
                .requestRecovery(true)
                .withIdentity(jobName, jobGroup)
                .build();

        if (params != null && !params.isEmpty()) {
            jobDetail.getJobDataMap().putAll(params);
        }


        SimpleTriggerImpl trigger = (SimpleTriggerImpl) TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobName, jobGroup)
                .startAt(nextFireTime)
                // 如果为misFire任务，项目启动后会执行一次；如果没有到达misFire的时间，项目启动后还会执行一次
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                .build();
        log.info("重复次数：{}, 错过执行策略：{}", trigger.getRepeatCount(), trigger.getMisfireInstruction());

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (ObjectAlreadyExistsException e) {
            log.error("重复创建批量任务");
        } catch (SchedulerException e) {
            log.error("创建simple任务失败", e);
        }

    }

}
