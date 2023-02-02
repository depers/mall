package cn.bravedawn.objectmapper;

import cn.bravedawn.objectmapper.dto.Car;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author : depers
 * @program : jackson-demo
 * @description:
 * @date : Created in 2023/2/1 17:18
 */
public class CustomCarDeserializer extends StdDeserializer<Car> {

    /**
     * 自定义反序列化器
     */

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public CustomCarDeserializer() {
        this(null);
    }


    public CustomCarDeserializer(final Class<?> vc) {
        super(vc);
    }

    public Car deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final Car car = new Car();
        final ObjectCodec codec = parser.getCodec();
        final JsonNode node = codec.readTree(parser);
        try {
            final JsonNode colorNode = node.get("color");
            final String color = colorNode.asText();
            car.setColor(color);
        } catch (final Exception e) {
            logger.debug("101_parse_exeption: unknown json.");
        }
        return car;
    }


    public static void main(String[] args) throws JsonProcessingException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module =
                new SimpleModule("CustomCarDeserializer", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(Car.class, new CustomCarDeserializer());
        mapper.registerModule(module);
        Car car = mapper.readValue(json, Car.class);
        System.out.println(car);
    }



}
