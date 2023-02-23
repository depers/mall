package cn.bravedawn.generic.typeerasure.tclass;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/23 22:31
 */

abstract class SuperClass<T> {

}


class User {
}

public class Main extends SuperClass<User>{


    /**
     * 演示如果通过类的继承关系，获取泛型的class对象
     * 所以结论是，还是无法通过泛型T直接获取Class对象
     */

    public static void main(String[] args) {
        // 获取 Main 的父类 SuperClass 的签名(携带泛型)
        Type genericSuperClass = Main.class.getGenericSuperclass();
        System.out.println(genericSuperClass);

        // 强转成 参数化类型 实体
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperClass;
        System.out.println(parameterizedType);

        // 获取超类的泛型类型数组. 即SuperClass<User>的<>中的内容, 因为泛型可以有多个, 所以用数组表示
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type genericType = actualTypeArguments[0];
        Class cls =  genericType.getClass();
        System.out.println(genericType);

    }
}