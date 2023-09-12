package cn.bravedawn.applicationcontext;

import cn.bravedawn.beanfactorydemo.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : depers
 * @program : 1.spring4.x
 * @description:
 * @date : Created in 2023/9/11 21:07
 */
@Configuration
public class Beans {


    @Bean(name = "car")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("红旗CA");
        car.setMaxSpeed(200);
        return car;
    }
}
