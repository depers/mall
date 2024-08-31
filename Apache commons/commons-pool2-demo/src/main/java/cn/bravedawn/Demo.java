package cn.bravedawn;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.time.Duration;

/**
 * @author : depers
 * @program : common-pool2-demo
 * @date : Created in 2024/7/16 14:08
 */

@Slf4j
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        ChannelFactory channelFactory = new ChannelFactory();
        GenericObjectPoolConfig<Channel> config = new GenericObjectPoolConfig<>();
        // 为了保证始终有10个可用的连接，这里的三个参数配置成一样的
        config.setMaxIdle(3);
        config.setMaxTotal(3);
        config.setMinIdle(3);
        config.setTestOnBorrow(true);
        config.setTestOnCreate(false);
        config.setTestWhileIdle(true);
        config.setTimeBetweenEvictionRuns(Duration.ofMillis(10000));
        GenericObjectPool<Channel> channelPool = new GenericObjectPool<>(channelFactory, config);


        Channel channel = null;
        try {
            channel = channelPool.borrowObject();
            log.info("发送请求~~~");
        } catch (Throwable e) {
            log.error("出现异常", e);
        } finally {
            if (channel != null) {
                channelPool.returnObject(channel);
            }
        }

        Thread.sleep(60000);
    }
}
