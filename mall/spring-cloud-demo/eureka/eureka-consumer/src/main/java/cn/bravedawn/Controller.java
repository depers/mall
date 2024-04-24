package cn.bravedawn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : depers
 * @program : spring-cloud-demo
 * @description:
 * @date : Created in 2021/12/6 21:43
 */

@RestController
@Slf4j
public class Controller {


    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        ServiceInstance instance = client.choose("eureka-client");

        if (instance == null) {
            return "No available instance";
        }

        String target = String.format("http://%s:%s/sayHi", instance.getHost(), instance.getPort());
        log.info("url is {}", target);

        return restTemplate.getForObject(target, String.class);
    }


    @PostMapping("/hello")
    public Friend helloPost() {
        ServiceInstance instance = client.choose("eureka-client");

        if (instance == null) {
            return null;
        }

        String target = String.format("http://%s:%s/sayHi", instance.getHost(), instance.getPort());
        log.info("url is {}", target);

        Friend friend = new Friend();
        friend.setName("Eureka consumer");

        return restTemplate.postForObject(target, friend, Friend.class);
    }
}
