package cn.bravedawn.client;

import cn.bravedawn.config.ClientConfiguration;
import cn.bravedawn.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author : depers
 * @program : openfeign-demo
 * @description:
 * @date : Created in 2022/12/15 16:02
 */
@FeignClient(value = "userClient",
        url = "http://localhost:8080/",
        configuration = ClientConfiguration.class)
public interface UserClient {


    @RequestMapping(method = RequestMethod.POST, path = "/register")
    Map register(@RequestBody Post post);
}
