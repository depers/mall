package cn.bravedawn.schedule;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class TestJob {


    @Scheduled(cron = "0/5 * * * * *")
    public void execute() {
        System.out.println("批量正在执行");
    }
}
