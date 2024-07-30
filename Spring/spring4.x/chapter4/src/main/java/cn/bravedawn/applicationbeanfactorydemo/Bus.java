package cn.bravedawn.applicationbeanfactorydemo;

/**
 * @author : depers
 * @program : chapter4
 * @description:
 * @date : Created in 2023/7/24 15:24
 */
public class Bus {

    private String name;
    private String color;
    private String speed;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", speed='" + speed + '\'' +
                '}';
    }
}
