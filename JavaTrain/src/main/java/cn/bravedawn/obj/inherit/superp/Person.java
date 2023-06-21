package cn.bravedawn.obj.inherit.superp;

public class Person {

    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    /**
     * 子类无法复写父类声明为private的方法
     */
    private String getName() {
        return name;
    }

    /**
     * 子类无法复写复写父类声明为final的方法
     */
    public final int getAge() {
        return age;
    }
}
