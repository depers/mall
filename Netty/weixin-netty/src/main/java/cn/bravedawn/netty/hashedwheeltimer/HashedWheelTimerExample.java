package cn.bravedawn.netty.hashedwheeltimer;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/6/30 15:37
 */
@Slf4j
public class HashedWheelTimerExample {

    public static void main(String[] args) {
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(1, TimeUnit.SECONDS, 8);
        log.info("init task");
        hashedWheelTimer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                log.info("run task");
            }
        }, 3, TimeUnit.SECONDS);


    }
}
