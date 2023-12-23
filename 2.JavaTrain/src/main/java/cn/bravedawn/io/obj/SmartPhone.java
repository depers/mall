package cn.bravedawn.io.obj;

import java.io.Serializable;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 17:19
 */
public class SmartPhone implements Serializable {

    private String price;
    private String brand;

    public SmartPhone(String price, String brand) {
        this.price = price;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "SmartPhone{" +
                "price='" + price + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
