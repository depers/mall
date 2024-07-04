package cn.bravedawn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : depers
 * @program : rabbitmq-spring-boot-retry-demo
 * @date : Created in 2024/6/18 14:34
 */
@Controller
public class TestController {

    @Autowired
    private RabbitSender rabbitSender;

    @GetMapping("/send")
    public void test(@RequestParam String msg){
        rabbitSender.send(msg);
    }
}
