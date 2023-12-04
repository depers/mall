package cn.bravedawn.customdeserializer;

import cn.bravedawn.customdeserializer.dto.Item;
import cn.bravedawn.customdeserializer.dto.Wrapper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

/**
 * @author : depers
 * @program : jackson-demo
 * @description:
 * @date : Created in 2023/4/13 10:21
 */
public class CustomGenericTypeDeserializer extends JsonDeserializer<Wrapper<?>> implements ContextualDeserializer {


    /**
     * 为泛型类型添加反序列化器
     */

    private JavaType type;


    /**
     * 在deserialize()中设置Wrapper值的具体类型
     *
     * @return
     * @throws IOException
     * @throws JsonProcessingException
     */
    @Override
    public Wrapper<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Wrapper<?> wrapper = new Wrapper<>();
        wrapper.setValue(ctxt.readValue(p, type));
        return wrapper;
    }

    /**
     * 获得Wrapper内部实体的类型
     *
     * @return
     * @throws JsonMappingException
     */
    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        this.type = property.getType().containedType(0);
        return this;
    }


    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\n" +
                "    \"id\": 1,\n" +
                "    \"itemName\": \"theItem\",\n" +
                "    \"owner\": {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"theUser\"\n" +
                "    }\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Wrapper.class, new CustomGenericTypeDeserializer());
        mapper.registerModule(module);

        Item readValue = mapper.readValue(json, Item.class);
        System.out.println(readValue);
    }
}
