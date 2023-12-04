package cn.bravedawn.customdeserializer;

import cn.bravedawn.customdeserializer.dto.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author : depers
 * @program : jackson-demo
 * @description:
 * @date : Created in 2023/4/13 10:07
 */
public class DefaultDeserializer {

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\n" +
                "    \"id\": 1,\n" +
                "    \"itemName\": \"theItem\",\n" +
                "    \"owner\": {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"theUser\"\n" +
                "    }\n" +
                "}";
        Item itemWithOwner = new ObjectMapper().readValue(json, Item.class);
        System.out.println(itemWithOwner);
    }
}
