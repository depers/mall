package cn.bravedawn.obj.inherit.polymorphic.codeblock.invokeorder;

/**
 * @Description : TODO
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-09-21 10:44
 */
public class Student extends Person{

    private String gender;


    static {
        System.out.println("Student类的静态代码块");
    }

    {
        System.out.println("Student类的实例初始化代码块");
    }


    public Student(String name, int age, String gender) {
        super(name, age);
        this.gender = gender;
        System.out.println("Person的构造函数");
    }
}
