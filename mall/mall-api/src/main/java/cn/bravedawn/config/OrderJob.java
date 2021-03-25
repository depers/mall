package cn.bravedawn.config;

import cn.bravedawn.service.OrderService;
import cn.bravedawn.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author 冯晓
 * @Date 2020/3/24 19:42
 */
@Component
public class OrderJob {

    @Autowired
    private OrderService orderService;

    /**
     * 从0点开始，每个小时执行一次定时关单
     */
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void closeOrder(){
        orderService.closeOrder();
        System.out.println("执行任务的当前时间： " +
                DateUtil.getCurrentDateString(DateUtil.DATETIME_PATTERN));
    }
}
