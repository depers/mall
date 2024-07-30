package cn.bravedawn;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : depers
 * @program : common-pool2-demo
 * @date : Created in 2024/7/16 13:55
 */

@Slf4j
public class Channel {

    private volatile boolean crate = false;

    public Channel() {
        log.info("创建连接");
    }

    public void close() {
        log.info("关闭连接");
    }

    public boolean reconnect() {
        log.info("测试请求连接服务器");
        if (!crate) {
            this.crate = true;
            log.info("创建连接，请求服务器成功");
            return true;
        }
        int res = (int) (Math.random() * 10);
        if (res > 5) {
            log.info("请求连接成功");
            return true;
        } else {
            log.info("请求连接失败");
            return false;
        }
    }
}
