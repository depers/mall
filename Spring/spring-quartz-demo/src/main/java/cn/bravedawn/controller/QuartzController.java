package cn.bravedawn.controller;

import cn.bravedawn.DatetimeUtil;
import cn.bravedawn.quartz.RealExecuteJob;
import cn.bravedawn.quartz.ScheduleUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : spring-quartz
 * @date : Created in 2024/7/29 15:13
 */

@RestController
@Slf4j
public class QuartzController {


    @Autowired
    private ScheduleUtils scheduleUtils;

    @GetMapping("/createJob")
    public void createJob() {
        Map<String, Object> param = new HashMap<>();
        param.put("hello", "world");

        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusSeconds(30);
        Date executeDate = DatetimeUtil.localDateTimeToDate(dateTime);
        scheduleUtils.addSimpleJob(RealExecuteJob.class, "simple", "default", "动态任务", param, executeDate);
        log.info("任务创建成功，执行时间：{}", executeDate);
    }

    @DeleteMapping("/delete")
    public void deleteJob() {
        scheduleUtils.deleteJob("simple", "default");
    }
}
