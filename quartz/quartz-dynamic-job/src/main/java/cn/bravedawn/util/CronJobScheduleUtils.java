package cn.bravedawn.util;

import cn.bravedawn.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author : depers
 * @program : quartz-dynamic-job
 * @date : Created in 2024/9/21 13:45
 */

@Component
@Slf4j
public class CronJobScheduleUtils extends ScheduleUtils {


    /**
     * 创建cron任务
     * @param jobClass 执行类
     * @param jobName 任务名
     * @param jobGroup 任务组
     * @param cronExpression cron表达式
     * @param desc 描述
     * @param params 附加参数
     * @return
     */
    public boolean addJob(Class<? extends Job> jobClass, String jobName, String jobGroup, String cronExpression, String desc, Map<String, Object> params) {
        try {
            if (isExistJob(jobName, jobGroup)) {
                log.error("批量作业已存在，jobName={}", jobName);
                return false;
            }

            JobDetail jobDetail = JobBuilder
                    .newJob(jobClass)
                    .storeDurably()
                    .requestRecovery()
                    .withIdentity(jobName, jobGroup)
                    .withDescription(StringUtils.substring(desc, 0, 250))
                    .build();

            if (params != null && !params.isEmpty()) {
                params.put(Constants.JOB_NAME, jobName);
                jobDetail.getJobDataMap().putAll(params);
            }

            CronTrigger cronTrigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity(TriggerKey.triggerKey(jobName, jobGroup))
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                    .withPriority(5)
                    .build();
            log.info("cron默认的错过策略是：{}", cronTrigger.getMisfireInstruction());

            scheduler.scheduleJob(jobDetail, cronTrigger);
            return true;
        } catch (SchedulerException e) {
            log.error("创建任务失败", e);
            return false;
        }
    }
}
