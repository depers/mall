package cn.bravedawn.obj.inherit.polymorphic.codeblock.invokeorder;

/**
 * @Description : TODO
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-09-21 10:44
 */
public class Person {

    private String name;
    private int age;


    static {
        System.out.println("Person类的静态代码块");
    }

    {
        System.out.println("Person类的实例初始化代码块");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person的构造函数");
    }
}
