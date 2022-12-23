package cn.bravedawn.obj.object.clone.deep.json.gson;

import com.google.gson.Gson;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/23 21:54
 */
public class GsonCopy {

    /**
     * Gson可以将对象序列化成JSON，也可以将JSON反序列化成对象，所以我们可以用它进行深拷贝。
     */

    public static void main(String[] args) {
        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 使用Gson序列化进行深拷贝
        Gson gson = new Gson();
        User copyUser = gson.fromJson(gson.toJson(user), User.class);

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        System.out.println(user.getAddress().getCity());
        System.out.println(copyUser.getAddress().getCity());
    }
}
