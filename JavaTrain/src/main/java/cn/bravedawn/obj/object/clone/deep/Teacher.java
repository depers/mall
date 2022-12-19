package cn.bravedawn.obj.object.clone.deep;



/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/19 17:05
 */
public class Teacher implements Cloneable {

    private String name;
    private int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
