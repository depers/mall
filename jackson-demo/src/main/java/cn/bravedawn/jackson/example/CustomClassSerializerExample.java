package cn.bravedawn.jackson.example;

import cn.bravedawn.jackson.dto.Item;
import cn.bravedawn.jackson.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: 定制json序列化
 * @date : Created in 2021/11/6 10:42
 */
public class CustomClassSerializerExample {


    public static void main(String[] args) throws JsonProcessingException {
        // 下面的案例配合@JsonSerialize(using = ItemSerializer.class)使用
        Item myItem = new Item(1, "theItem", new User(2, "theUser"));
        String serialized = new ObjectMapper().writeValueAsString(myItem);
        System.out.println(serialized);
    }
}
