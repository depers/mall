package cn.bravedawn;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author : depers
 * @program : ratelimiter
 * @description:
 * @date : Created in 2021/10/28 6:43
 */

@RestController
@Slf4j
public class Controller {

    RateLimiter limiter = RateLimiter.create(2.0);


    // 非阻塞限流
    @GetMapping("/tryAcquire")
    public String tryAcquire(Integer count) {
        if (limiter.tryAcquire(count)) {
            log.info("success, rate is {}", limiter.getRate());
            return "success";
        } else {
            log.info("fail, rate is {}", limiter.getRate());
            return "fail";
        }
    }


    // 限定时间的非阻塞限流
    @GetMapping("/tryAcquireWithTimeout")
    public String tryAcquireWithTimeout(Integer count, Integer timeout) {
        if (limiter.tryAcquire(count, timeout, TimeUnit.SECONDS)) {
            log.info("success, rate is {}", limiter.getRate());
            return "success";
        } else {
            log.info("fail, rate is {}", limiter.getRate());
            return "fail";
        }
    }

    // 同步阻塞限流
    @GetMapping("/acquire")
    public String acquire(Integer count) {
        limiter.acquire(count);
        log.info("success, rate is {}", limiter.getRate());
        return "success";
    }

    // Nginx专用
    // 1. 修改host文件 -> www.limiters.com = localhost 127.0.0.1
    //    (127.0.0.1	www.limiters.com)
    // 2. 修改nginx -> 将步骤1中的域名，添加到路由规则当中
    //    配置文件地址： /usr/local/nginx/conf/nginx.conf
    // 3. 添加配置项：参考resources文件夹下面的nginx.conf
    //
    // 重新加载nginx(Nginx处于启动) => sudo /usr/local/nginx/sbin/nginx -s reload
    @GetMapping("/nginx")
    public String nginx() {
        log.info("Nginx success");
        return "success";
    }
}
