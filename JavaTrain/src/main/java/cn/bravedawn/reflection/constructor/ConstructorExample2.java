package cn.bravedawn.reflection.constructor;

import cn.bravedawn.reflection.newinstance.Person;

import java.lang.reflect.Constructor;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/28 21:08
 */
public class ConstructorExample2 {

    /**
     * 获取类对象的构造方法
     * Class.getConstructors()：获取类对象的所有构造函数
     * Class.getConstructor(Class... paramTypes)：获取指定的构造函数
     */

    public static void main(String[] args) throws NoSuchMethodException {
        Class cls = Person.class;
        for (Constructor constructor : cls.getConstructors()) {
            System.out.println(constructor);
        }

        Constructor constructor = cls.getConstructor(String.class, int.class);
        System.out.println(constructor);
    }
}
