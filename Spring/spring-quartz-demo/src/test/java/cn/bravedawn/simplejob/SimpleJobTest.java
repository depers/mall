package cn.bravedawn.simplejob;

import cn.bravedawn.DatetimeUtil;
import cn.bravedawn.quartz.simpletrigger.RealExecuteJob;
import cn.bravedawn.quartz.ScheduleUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : spring-quartz
 * @date : Created in 2024/7/29 14:31
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class SimpleJobTest {

    @Autowired
    private ScheduleUtils scheduleUtils;

    @Test
    public void testSimpleJob() throws InterruptedException {
        Map<String, Object> param = new HashMap<>();
        param.put("hello", "world");

        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.plusMinutes(10);
        Date executeDate = DatetimeUtil.localDateTimeToDate(dateTime);
        scheduleUtils.addSimpleJob(RealExecuteJob.class, "simple", "default", "动态任务", param, executeDate);
        log.info("任务创建成功");


        boolean existJob = scheduleUtils.isExistJob("simple", "default");
        log.info("任务是否存在：{}", existJob);


        Thread.sleep(60000);
        scheduleUtils.deleteJob("simple", "default");

    }
}
