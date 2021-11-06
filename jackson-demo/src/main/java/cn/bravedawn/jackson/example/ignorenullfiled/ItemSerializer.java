package cn.bravedawn.jackson.example.ignorenullfiled;

import cn.bravedawn.jackson.dto.Item;
import cn.bravedawn.jackson.dto.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * @author : depers
 * @program : jackson-demo
 * @description: 定制json序列化
 * @date : Created in 2021/11/6 10:42
 */
public class ItemSerializer extends StdSerializer<Item> {

    public ItemSerializer() {
        this(null);
    }
    protected ItemSerializer(Class<Item> t) {
        super(t);
    }

    @Override
    public void serialize(Item value, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", value.id);
        jgen.writeStringField("itemName", value.itemName);
        jgen.writeNumberField("owner", value.owner.id);
        jgen.writeEndObject();
    }
}
