package cn.bravedawn.obj.object.clone.deep.json.jackson;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/23 22:08
 */
public class JacksonCopy {

    /**
     * Jackson与Gson相似，可以将对象序列化成JSON，明显不同的地方是拷贝的类（包括其成员变量）需要有默认的无参构造函数。
     */

    public static void main(String[] args) throws JsonProcessingException {
        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 使用Jackson序列化进行深拷贝
        ObjectMapper objectMapper = new ObjectMapper();
        User copyUser = objectMapper.readValue(objectMapper.writeValueAsString(user), User.class);

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 打印两个对象的地址城市
        System.out.println(user.getAddress().getCity());
        System.out.println(copyUser.getAddress().getCity());
    }
}
