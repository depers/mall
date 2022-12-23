package cn.bravedawn.obj.object.clone.deep.constructor;

import org.apache.commons.lang3.StringUtils;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/21 14:25
 */
public class ConstructorCopy {

    /**
     * 深拷贝方法一：构造函数
     * 我们可以通过在调用构造函数进行深拷贝，形参如果是基本类型和字符串则直接赋值，如果是对象则重新new一个。
     */

    public static void main(String[] args) {
        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 调用构造函数时进行深拷贝
        User copyUser = new User(user.getName(), new Address(address.getCity(), address.getCountry()));

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        System.out.println(StringUtils.equals(user.getAddress().getCity(), copyUser.getAddress().getCity()));
    }
}
