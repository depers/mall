package cn.bravedawn.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
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
public class ScheduleUtils {

    @Autowired
    private Scheduler scheduler;


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

        if (isExistJob(jobName, jobGroup)) {
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
                .build();
        trigger.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
        trigger.setRepeatCount(1);
        trigger.setRepeatInterval(2000);
        log.info("重复次数：{}, 错过执行策略：{}", trigger.getRepeatCount(), trigger.getMisfireInstruction());

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (ObjectAlreadyExistsException e) {
            log.error("重复创建批量任务");
        } catch (SchedulerException e) {
            log.error("创建simple任务失败", e);
        }

    }


    /**
     * 判断简单任务是否存在
     * @param jobName
     * @param jobGroup
     * @return
     */
    public boolean isExistJob(String jobName, String jobGroup) {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        try {
            return scheduler.checkExists(jobKey);
        } catch (SchedulerException e) {
            log.error("检查批量是否存在报错", e.getMessage());
        }
        return false;
    }


    /**
     * 删除简单任务
     * @param jobName
     * @param jobGroup
     */
    public void deleteJob(String jobName, String jobGroup) {

        if (!isExistJob(jobName, jobGroup)) {
            log.info("批量不存在, jobName={}", jobName);
            return;
        }
        TriggerKey triggerKey = new TriggerKey(jobName, jobGroup);
        try {
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            JobKey jobKey = new JobKey(jobName, jobGroup);
            scheduler.deleteJob(jobKey);
            log.info("删除任务成功, jobName={}", jobName);
        } catch (SchedulerException e) {
            log.error("删除批量任务失败", e);
        }

    }
}
