package cn.bravedawn.factorybean;

/**
 * @author : depers
 * @program : 1.spring4.x
 * @date : Created in 2024/5/14 09:45
 */
public class Car {

    private String brand;
    private int price;
    private int maxSpeed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
