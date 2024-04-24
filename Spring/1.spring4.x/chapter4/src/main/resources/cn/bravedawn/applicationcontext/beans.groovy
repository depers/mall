package cn.bravedawn.applicationcontext

import cn.bravedawn.beanfactorydemo.Car

/**
 * @author : depers
 * @program : 1.spring4.x
 * @description:
 * @date : Created in 2023/9/12 20:17
 */
beans {

    car(Car) { // 名字(类型)
        brand = "红旗CA72" // 注入属性
        maxSpeed = "200"
        color = "red"
    }
}
