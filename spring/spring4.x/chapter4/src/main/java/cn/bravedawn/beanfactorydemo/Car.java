package cn.bravedawn.beanfactorydemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author : depers
 * @program : spring-demo
 * @description:
 * @date : Created in 2023/5/21 10:49
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("【Bean自身的方法】调用Car()构造函数，进行实例化");
    }

    public void setBrand(String brand) {
        System.out.println("【Bean自身的方法】调用setBrand()设置属性值");
        this.brand = brand;
    }

    public void introduce() {
        System.out.println("brand: " + brand + ", color: " + color + ", maxSpeed: " + maxSpeed);
    }

    // 调用BeanFactoryAware接口方法
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()方法");
        this.beanFactory = beanFactory;
    }

    // 调用BeanNameAware接口方法
    public void setBeanName(String s) {
        System.out.println("调用BeanNameAware.setBeanName()方法");
        this.beanName = s;
    }


    // 调用InitializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()方法");
    }

    // 调用DisposableBean接口方法
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destroy()方法");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("【Bean自身的方法】调用init-method所指定的myInit()，将maxSpeed设置为240");
        this.maxSpeed = 240;
    }

    // 通过<bean>的destroy-method属性指定的销毁方法
    public void myDestroy() {
        System.out.println("【Bean自身的方法】调用destroy-method所指定的myDestroy方法");
    }


    // -------------------------------------------

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }
}
