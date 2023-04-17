package cn.bravedawn.customdeserializer.dto;

/**
 * @author : depers
 * @program : jackson-demo
 * @description:
 * @date : Created in 2023/4/13 10:11
 */
public class User {

    public int id;
    public String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
