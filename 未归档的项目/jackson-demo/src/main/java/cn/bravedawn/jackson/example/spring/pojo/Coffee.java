package cn.bravedawn.jackson.example.spring.pojo;

import java.time.LocalDateTime;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: 咖啡
 * @date : Created in 2021/11/6 13:19
 */
public class Coffee {

    private String name;
    private String brand;
    private LocalDateTime date;

    public String getName() {
        return name;
    }

    public Coffee  setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Coffee  setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Coffee setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
