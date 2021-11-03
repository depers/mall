package cn.bravedawn.ratelimiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : depers
 * @program : ratelimiter
 * @description: 测试类
 * @date : Created in 2021/11/3 21:46
 */
@RestController
public class Controller {

    @Autowired
    private AccessLimiter accessLimiter;

    @GetMapping("test")
    public String test() {
        accessLimiter.limitAccess("ratelimiter-test", 1);
        return "success";
    }


    // 提醒！ 注意配置扫包路径（cn.bravedawn.ratelimiter.annotation路径不同）
    @GetMapping("test-annotation")
    @cn.bravedawn.ratelimiter.annotation.AccessLimiter(limit = 1)
    public String testAnnotation() {
        return "success";
    }
}
