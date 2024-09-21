package cn.bravedawn.controller;

import cn.bravedawn.quartz.simple.SimpleJob;
import cn.bravedawn.util.DatetimeUtil;
import cn.bravedawn.util.SimpleJobScheduleUtils;
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
 * @date : Created in 2024/9/21 13:43
 */
@RestController
@RequestMapping("simple")
public class SimpleController {


    @Autowired
    private SimpleJobScheduleUtils simpleJobScheduleUtils;


    @GetMapping("createJob")
    public String createJob() {
        Date startTime = DatetimeUtil.localDatetime2Date(LocalDateTime.now().plusSeconds(20));
        simpleJobScheduleUtils.addJob(SimpleJob.class, "simpleJob", "quartz", "新建simple任务", new HashMap<String, Object>(), startTime);
        return "success";
    }


    @GetMapping("pauseJob")
    public String pauseJob() {
        simpleJobScheduleUtils.pauseJob("simple", "quartz");
        return "success";
    }

    @GetMapping("resumeJob")
    public String resumeJob() {
        simpleJobScheduleUtils.resumeJob("simple", "quartz");
        return "success";
    }

    @GetMapping("deleteJob")
    public String deleteJob() {
        simpleJobScheduleUtils.deleteJob("simple", "quartz");
        return "success";
    }
}
