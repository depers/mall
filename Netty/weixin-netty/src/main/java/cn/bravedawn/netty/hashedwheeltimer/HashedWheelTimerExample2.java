package cn.bravedawn.netty.hashedwheeltimer;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/30 15:46
 */
@Slf4j
public class HashedWheelTimerExample2 {

    public static void main(String[] args) throws InterruptedException {
        log.info("init task 2...");

        HashedWheelTimer timer = new HashedWheelTimer(1, TimeUnit.SECONDS, 8);

        Thread.sleep(5000);

        // add a new timeout
        Timeout tm = timer.newTimeout(timeout -> {
            log.info("running task 2...");
        }, 5, TimeUnit.SECONDS);

        // cancel
        if (!tm.isExpired()) {
            log.info("cancel task 2...");
            tm.cancel();
        }

        // reschedule
        timer.newTimeout(tm.task(), 3, TimeUnit.SECONDS);
    }

}
