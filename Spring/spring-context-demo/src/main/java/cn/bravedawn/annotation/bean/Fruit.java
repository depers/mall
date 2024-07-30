package cn.bravedawn.annotation.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;

/**
 * @author : depers
 * @program : spring-context-demo
 * @date : Created in 2024/7/30 10:16
 */
@Data
@AllArgsConstructor
public class Fruit {


    private String name;
    private String color;

}
