package cn.bravedawn.collection.list.copylist.commonslang3;

import java.io.Serializable;
import java.util.Date;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/19 11:10
 */
public class Plant implements Serializable {

    private String name;
    private String color;
    private Date florescence;

    public Plant(String name, String color, Date florescence) {
        this.name = name;
        this.color = color;
        this.florescence = florescence;
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

    public Date getFlorescence() {
        return florescence;
    }

    public void setFlorescence(Date florescence) {
        this.florescence = florescence;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", florescence=" + florescence +
                '}';
    }


}
