package cn.bravedawn.controller;

import cn.bravedawn.quartz.cron.CronJob;
import cn.bravedawn.quartz.simple.SimpleJob;
import cn.bravedawn.util.CronJobScheduleUtils;
import cn.bravedawn.util.DatetimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

/**
 * @author : depers
 * @program : quartz-dynamic-job
 * @date : Created in 2024/9/21 13:42
 */

@RestController
@RequestMapping("cron")
public class CronController {

    @Autowired
    private CronJobScheduleUtils cronJobScheduleUtils;


    @GetMapping("createJob")
    public String createJob() {
        Date startTime = DatetimeUtil.localDatetime2Date(LocalDateTime.now().plusSeconds(20));
        cronJobScheduleUtils.addJob(CronJob.class, "cronJob", "quartz", "0/10 * * * * ? ", "新建cron任务", new HashMap<>());
        return "success";
    }


    @GetMapping("pauseJob")
    public String pauseJob() {
        cronJobScheduleUtils.pauseJob("cronJob", "quartz");
        return "success";
    }

    @GetMapping("resumeJob")
    public String resumeJob() {
        cronJobScheduleUtils.resumeJob("cronJob", "quartz");
        return "success";
    }

    @GetMapping("deleteJob")
    public String deleteJob() {
        cronJobScheduleUtils.deleteJob("cronJob", "quartz");
        return "success";
    }
}
