package cn.bravedawn.annotations.autowried;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author : depers
 * @program : spring-beans-demo
 * @date : Created in 2024/7/30 09:24
 */

@Service
@Slf4j
public class FruitService {

    @Autowired
    private Fruit apple;

    public void getFruit() {
        log.info("fruit: {}", apple.getName());
    }
}
