package cn.bravedawn.reflection.newinstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/28 21:11
 */
public class ConstructorNewInstance {

    /**
     * 通过反射实例化对象的方法二：通过构造方法创建实例对象
     */

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class cls = Person.class;

        Constructor constructor = cls.getConstructor(String.class, int.class);
        Person person = (Person) constructor.newInstance("fengxiao", 18);
        System.out.println(person);
    }
}
