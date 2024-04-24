package cn.bravedawn.reflection.beaninfo;

/**
 * @Description : TODO
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-08 13:50
 */
public class Student extends Person{

    private int scope;

    public Student(String id, String name, int age, int scope) {
        super(id, name, age);
        this.scope = scope;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }
}
