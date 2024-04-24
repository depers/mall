package cn.bravedawn.customdeserializer;

import cn.bravedawn.customdeserializer.dto.Car;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author : depers
 * @program : jackson-demo
 * @description:
 * @date : Created in 2023/2/1 17:18
 */
public class CustomDeserializer extends StdDeserializer<Car> {

    /**
     * 自定义反序列化器
     *
     * 适用场景：当我们需要解析的json无法完美的切合我们的实体类时，我们就可以自定义反序列化器，从json中获取特定的属性放置到对象中，
     * 从而构造出我们想要的对象
     *
     * 比如下面这个例子，我的json种有三个字段，但是我的car对象只有两个属性，其他的一个我不需要。此外使用默认的的反序列化器会报错
     */

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public CustomDeserializer() {
        this(null);
    }


    public CustomDeserializer(final Class<?> vc) {
        super(vc);
    }

    public Car deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final Car car = new Car();
        final ObjectCodec codec = parser.getCodec();
        final JsonNode node = codec.readTree(parser);
        try {
            final JsonNode colorNode = node.get("color");
            final String color = colorNode.asText();
            final float price = (float) node.get("price").asDouble();
            car.setColor(color);
            car.setPrice(price);
        } catch (final Exception e) {
            logger.debug("101_parse_exeption: unknown json.");
        }
        return car;
    }


    public static void main(String[] args) throws JsonProcessingException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\", \"price\": 12.1 }";
        useDefaultDeserializer(json);
    }

    public static void useCustomDeserializer(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module =
                new SimpleModule("CustomCarDeserializer", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(Car.class, new CustomDeserializer());
        mapper.registerModule(module);
        Car car = mapper.readValue(json, Car.class);
        System.out.println(car);

    }


    /**
     * 这个方法是会报错的，因为Car类没有type属性
     * @param json
     * @throws JsonProcessingException
     */
    public static void useDefaultDeserializer(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Car car = mapper.readValue(json, Car.class);
        System.out.println(car);

    }

}
