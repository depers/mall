package cn.bravedawn.quartz.cron;

import cn.bravedawn.common.Constants;
import cn.bravedawn.util.DatetimeUtil;
import cn.bravedawn.util.SnowflakeUtil;
import cn.hutool.extra.spring.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.MDC;

import java.util.Date;

/**
 * @author : depers
 * @program : quartz-dynamic-job
 * @date : Created in 2024/9/21 13:48
 */
@Slf4j
public class CronParentJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        MDC.put(Constants.LOG4J2_ID, String.valueOf(SnowflakeUtil.getId()));
        String jobName = null;
        try {
            jobName = (String) context.getMergedJobDataMap().get(Constants.JOB_NAME);
            log.info("开始执行任务，任务名称：{}, 开始执行时间：{}", jobName,DatetimeUtil.dateToStrMills(new Date()));
            Job job = SpringUtil.getBean(jobName);
            job.execute(context);
        } finally {
            log.info("任务执行结束，任务名称：{}, 结束执行时间：{}", jobName, DatetimeUtil.dateToStrMills(new Date()));
        }
    }
}
