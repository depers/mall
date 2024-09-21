package cn.bravedawn.quartz.simple;

import cn.bravedawn.common.Constants;
import cn.bravedawn.util.IPUtil;
import cn.bravedawn.util.SnowflakeUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
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
public abstract class SimpleParentJob implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        long startMills = System.currentTimeMillis();
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        String jobName = jobDataMap.getString(Constants.JOB_NAME);
        Date startTime = context.getTrigger().getStartTime();
        String flowId = String.valueOf(SnowflakeUtil.getId());
        String ip = IPUtil.getServerIp();

        try {
            log.info("开始执行动态创建的任务，jobName={}, startTime={}, flowId={}, ip={}", jobName, startTime, flowId, ip);
            MDC.put(Constants.LOG4J2_ID, flowId);
            execute(jobDataMap);
        } catch (Throwable e) {
            log.error("任务执行出现异常", e);
        } finally {
            log.info("动态任务执行结束，jobName={}, 耗时={}", jobName, System.currentTimeMillis() - startMills);
        }
    }

    public abstract void execute(JobDataMap jobDataMap);
}
