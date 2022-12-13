package cn.bravedawn;

import cn.bravedawn.client.JSONPlaceHolderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : openfeign-demo
 * @description:
 * @date : Created in 2022/12/8 12:39
 */

@Component
@Slf4j
public class CustomerRunner implements ApplicationRunner {

    @Autowired
    private JSONPlaceHolderClient jsonPlaceHolderClient;


    public void run(ApplicationArguments args) throws Exception {
        log.info(jsonPlaceHolderClient.getPosts().toString());
    }
}
