package cn.bravedawn;

/**
 * @author : depers
 * @program : spring4.x
 * @description:
 * @date : Created in 2023/7/28 20:56
 */
public class Customer {
    private long id;
    private String name;
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
