package cn.bravedawn.collection.list.intersectiontwolists;

import java.util.Objects;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/19 11:10
 */
public class Plant {

    private String name;
    private String color;

    public Plant(String name, String color) {
        this.name = name;
        this.color = color;
    }

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

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plant)) return false;
        Plant plant = (Plant) o;
        return Objects.equals(getName(), plant.getName()) && Objects.equals(getColor(), plant.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getColor());
    }
}
