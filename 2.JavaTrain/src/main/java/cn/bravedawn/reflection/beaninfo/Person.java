package cn.bravedawn.reflection.beaninfo;

/**
 * @Description : 实体类
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-08 13:48
 */
public class Person {


    private String id;
    private String name;
    private int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}
