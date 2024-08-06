package cn.bravedawn.quartz.common;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : spring-quartz-demo
 * @date : Created in 2024/8/5 15:34
 */

@Component
@Slf4j
public class ScheduleUtils {


    @Autowired
    private Scheduler scheduler;

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
