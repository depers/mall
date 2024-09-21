package cn.bravedawn.util;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : quartz-dynamic-job
 * @date : Created in 2024/9/21 13:49
 */

@Component
@Slf4j
public class ScheduleUtils {


    @Autowired
    protected Scheduler scheduler;


    /**
     * 校验批量是否存在
     * @param jobName 批量名称
     * @param jobGroup 批量所属的组
     * @return
     */
    public boolean isExistJob(String jobName, String jobGroup) {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        try {
            return scheduler.checkExists(jobKey);
        } catch (SchedulerException e) {
            log.error("检查批量是否存在，出现异常", e);
            return false;
        }
    }


    /**
     * 删除批量
     * @param jobName 批量名称
     * @param jobGroup 批量组
     * @return
     */
    public boolean deleteJob(String jobName, String jobGroup) {
        if (!isExistJob(jobName, jobGroup)) {
            log.info("批量不存在，jobName:{}, jobGroup:{}", jobName, jobGroup);
            return false;
        }

        TriggerKey triggerKey = new TriggerKey(jobName, jobGroup);
        try {
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(JobKey.jobKey(jobName, jobGroup));
            log.info("批量删除成功jobName:{}, jobGroup:{}", jobName, jobGroup);
            return true;
        } catch (SchedulerException e) {
            log.error("删除批量任务出现异常", e);
            return false;
        }
    }

    /**
     * 暂停批量
     * @param jobName 批量名称
     * @param jobGroup 批量组
     * @return
     */
    public boolean pauseJob(String jobName, String jobGroup) {
        if (!isExistJob(jobName, jobGroup)) {
            log.info("批量不存在，jobName:{}, jobGroup:{}", jobName, jobGroup);
            return false;
        }

        try {
            scheduler.pauseJob(JobKey.jobKey(jobName, jobGroup));
            return true;
        } catch (SchedulerException e) {
            log.error("暂停批量失败", e);
            return false;
        }
    }


    /**
     * 恢复批量
     * @param jobName 批量名称
     * @param jobGroup 批量组
     * @return
     */
    public boolean resumeJob(String jobName, String jobGroup) {
        if (!isExistJob(jobName, jobGroup)) {
            log.info("批量不存在，jobName:{}, jobGroup:{}", jobName, jobGroup);
            return false;
        }

        try {
            scheduler.resumeJob(JobKey.jobKey(jobName, jobGroup));
            return true;
        } catch (SchedulerException e) {
            log.error("恢复批量出现异常", e);
            return false;
        }
    }


}
