package cn.bravedawn.obj.object.clone.deep.serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/21 17:55
 */
public class SerializableCopy {

    /**
     * 修改User类，Address类，实现Serializable接口，使其支持序列化。然后使用SerializationUtils工具类进行克隆
     */

    public static void main(String[] args) {
        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 使用Apache Commons Lang序列化进行深拷贝
        User copyUser = (User) SerializationUtils.clone(user);

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        System.out.println(StringUtils.equals(user.getAddress().getCity(), copyUser.getAddress().getCity()));

    }
}
