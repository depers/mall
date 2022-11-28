package cn.bravedawn.collection.list.copylist.clonemethod;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/19 11:10
 */
public class Plant implements Cloneable{

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
    protected Object clone() throws CloneNotSupportedException {
        return new Plant(name, color);
    }
}
