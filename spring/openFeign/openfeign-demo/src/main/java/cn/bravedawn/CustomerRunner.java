package cn.bravedawn;

import cn.bravedawn.client.JSONPlaceHolderClient;
import cn.bravedawn.client.UserClient;
import cn.bravedawn.model.Post;
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

    @Autowired
    private UserClient userClient;


    public void run(ApplicationArguments args) throws Exception {
        System.out.println("-----------------------------------------");
        System.out.println(jsonPlaceHolderClient.getPostById(1l));
        System.out.println("-----------------------------------------");
    }

    private void testRegister() {
        Post post = new Post("17393164120", Long.MAX_VALUE,
                "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto");

        log.info(userClient.register(post).toString());

    }
}
