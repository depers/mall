package cn.bravedawn.reflection.newinstance;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/28 21:04
 */
public class ClassNewInstance {

    /**
     * 通过反射实例化对象的方法一：调用Class提供的`newInstance()`方法，创建无参构造函数的实例
     *
     * 但是如果类本身没有提供无参构造器，直接使用该方法是会报错的。
     */

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Person person = Person.class.newInstance();
        person.setName("depers");
        person.setAge(18);
        System.out.println(person);
    }
}
