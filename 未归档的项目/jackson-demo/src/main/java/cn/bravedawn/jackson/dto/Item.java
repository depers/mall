package cn.bravedawn.jackson.dto;

import cn.bravedawn.jackson.example.ignorenullfiled.ItemSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: Item
 * @date : Created in 2021/11/6 11:35
 */
@JsonSerialize(using = ItemSerializer.class)
public class Item {

    public int id;
    public String itemName;
    public User owner;

    public Item(int id, String itemName, User owner) {
        this.id = id;
        this.itemName = itemName;
        this.owner = owner;
    }
}
