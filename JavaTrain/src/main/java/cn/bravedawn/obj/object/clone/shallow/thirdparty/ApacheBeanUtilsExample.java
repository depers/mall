package cn.bravedawn.obj.object.clone.shallow.thirdparty;


import org.springframework.beans.BeanUtils;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/23 22:30
 */
public class ApacheBeanUtilsExample {

    /**
     * 使用Apache BeanUtils实现对象的浅复制
     */

    public static void main(String[] args) {
        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        User copyUser = new User();
        user.getAddress().setCity("北京");
        BeanUtils.copyProperties(user, copyUser);

        System.out.println(user);
        System.out.println(copyUser);
    }
}
