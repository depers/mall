package cn.bravedawn.annotation.bean;

import lombok.Data;

/**
 * @author : depers
 * @program : spring-context-demo
 * @date : Created in 2024/7/30 10:19
 */

@Data
public class FruitService {

    private Fruit fruit;

    public void getFruitInfo() {
        System.out.println("通过Bean方法注入的类型是：" + fruit.getName());
    }
}
