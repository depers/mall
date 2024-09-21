package cn.bravedawn.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author : depers
 * @program : quartz-dynamic-job
 * @date : Created in 2024/9/21 13:49
 */
@Slf4j
@Component
public class SimpleJobScheduleUtils extends ScheduleUtils {


    /**
     * 创建simple任务
     * @param jobClass 执行任务的实际类
     * @param jobName 任务名称
     * @param jobGroup 任务组
     * @param desc 任务描述
     * @param dataMap 附加信息
     * @param startTime 任务开始执行时间
     * @return
     */
    public boolean addJob(Class<? extends Job> jobClass, String jobName, String jobGroup, String desc, Map<String, Object> dataMap, Date startTime) {

        try {
            if (isExistJob(jobName, jobGroup)) {
                log.error("批量已经存在，jobName={}, jobGroup={}", jobName, jobGroup);
                return true;
            }

            JobDetail jobDetail = JobBuilder
                    .newJob(jobClass)
                    .storeDurably()
                    .requestRecovery()
                    .withIdentity(jobName, jobGroup)
                    .withDescription(StringUtils.substring(desc, 0 , 250))
                    .build();

            if (dataMap != null && !dataMap.isEmpty()) {
                jobDetail.getJobDataMap().putAll(dataMap);
            }

            SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                    .forJob(jobName)
                    .withIdentity(TriggerKey.triggerKey(jobName, jobGroup))
                    .startAt(startTime)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                    .build();

            log.info("重复次数：{}, 错过执行的策略：{}", simpleTrigger.getRepeatCount(), simpleTrigger.getMisfireInstruction());
            scheduler.scheduleJob(jobDetail, simpleTrigger);
            log.info("批量：{}, 执行时间：{}, 创建成功", jobName, DatetimeUtil.dateToStr(startTime));
            return true;
        } catch (ObjectAlreadyExistsException e) {
            log.error("重复创建批量，jobName={}, jobGroup={}", jobName, jobGroup);
        } catch (SchedulerException e) {
            log.error("创建批量异常", e);
        }
        return false;
    }
}
