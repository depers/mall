package cn.bravedawn.annotations.autowried;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author : depers
 * @program : spring-beans-demo
 * @date : Created in 2024/7/30 09:26
 */
@Component
public class FruitApplicationRunner implements CommandLineRunner {

    @Autowired
    private FruitService fruitService;

    // @Override
    // public void run(ApplicationArguments args) throws Exception {
    //
    // }

    @Override
    public void run(String... args) throws Exception {
        fruitService.getFruit();
    }
}
