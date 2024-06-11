package cn.bravedawn.chapter20.serializer;

import com.alibaba.fastjson.JSON;

/**
 * @author : depers
 * @program : weixin-netty
 * @date : Created in 2024/2/19 15:52
 *
 * JSON序列化算法实现
 */
public class JSONSerializer implements Serializer {

    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serializer(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserializer(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
