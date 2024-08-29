package cn.bravedawn.controller;

import cn.bravedawn.DatetimeUtil;
import cn.bravedawn.quartz.common.ScheduleUtils;
import cn.bravedawn.quartz.crontrigger.CronTriggerScheduleUtils;
import cn.bravedawn.quartz.simpletrigger.RealExecuteJob;
import cn.bravedawn.quartz.simpletrigger.SimpleTriggerScheduleUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author : depers
 * @program : spring-quartz
 * @date : Created in 2024/7/29 15:13
 */

@RestController
@Slf4j
public class QuartzController {


    @Autowired
    private SimpleTriggerScheduleUtils simpleTriggerScheduleUtils;

    @Autowired
    private CronTriggerScheduleUtils cronTriggerScheduleUtils;

    @Autowired
    private ScheduleUtils scheduleUtils;

    @GetMapping("/createJob")
    public void createJob() {
        Map<String, Object> param = new HashMap<>();
        param.put("hello", "world");

        LocalDateTime dateTime = LocalDateTime.of(2024, 8, 25, 9, 45, 0);
        // dateTime = dateTime.plusSeconds(30);
        dateTime = dateTime.plusSeconds(30);
        String jobName = "simple" + UUID.randomUUID().toString().replace("-", "");
        Date executeDate = DatetimeUtil.localDateTimeToDate(dateTime);
        simpleTriggerScheduleUtils.addSimpleJob(RealExecuteJob.class, jobName, "default", "动态任务", param, executeDate);
        log.info("任务创建成功，执行时间：{}", executeDate);
    }

    @DeleteMapping("/delete")
    public void deleteJob(@RequestParam String jobName,
                          @RequestParam String jobGroup) {
        scheduleUtils.deleteJob(jobName, jobGroup);
    }

    @GetMapping("/createCronJob")
    public void createCronJob() throws SchedulerException {
        Map<String, Object> param = new HashMap<>();
        param.put("hello", "world");

        cronTriggerScheduleUtils.addCronJob("cronJob", "default", "0 0/1 * * * ?", param);
    }
}
