package cn.bravedawn.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @author : depers
 * @program : spring-quartz
 * @date : Created in 2024/7/29 14:37
 */
@DisallowConcurrentExecution
@Validated
@Slf4j
public abstract class DynamicJob implements Job {

    public abstract void executeJob(@NotNull Map<String, Object> jobDataMap);


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Map<String, Object> params = context.getJobDetail().getJobDataMap();
        String jobName = context.getJobDetail().getKey().getName();
        String jobGroup = context.getJobDetail().getKey().getGroup();
        log.info("开始执行动态创建的任务, jobName:{}, jobGroup:{}", jobName, jobGroup);
        try {
            executeJob(params);
        } catch (Throwable e) {
            log.error("任务执行出现异常", e);
        }
        log.info("任务执行结束");
    }
}
