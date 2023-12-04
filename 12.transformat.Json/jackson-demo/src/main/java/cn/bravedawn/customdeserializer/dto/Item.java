package cn.bravedawn.customdeserializer.dto;

import cn.bravedawn.customdeserializer.DefaultDeserializer;

/**
 * @author : depers
 * @program : jackson-demo
 * @description:
 * @date : Created in 2023/4/13 10:11
 */
public class Item {

    public int id;
    public String itemName;
    public User owner;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", owner=" + owner +
                '}';
    }
}
