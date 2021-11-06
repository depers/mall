package cn.bravedawn.jackson.example;

import cn.bravedawn.jackson.dto.Item;
import cn.bravedawn.jackson.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: 定制json序列化
 * @date : Created in 2021/11/6 10:42
 */
public class CustomClassSerializerExample2 {


    public static void main(String[] args) throws JsonProcessingException {
        Item myItem = new Item(1, "theItem", new User(2, "theUser"));
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(Item.class, new ItemSerializer());
        mapper.registerModule(module);
        String serialized = mapper.writeValueAsString(myItem);

        System.out.println(serialized);
    }
}
