package cn.bravedawn.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author : depers
 * @program : 1.spring4.x
 * @date : Created in 2024/5/14 09:48
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    /**
     * 构建创建bean的具体逻辑，如果isSingleton为true，则会将该实例放置到Spring的单例缓存池中
     * @return
     * @throws Exception
     */
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);

        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
