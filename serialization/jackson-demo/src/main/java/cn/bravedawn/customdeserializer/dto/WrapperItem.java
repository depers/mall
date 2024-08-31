package cn.bravedawn.customdeserializer.dto;

/**
 * @author : depers
 * @program : jackson-demo
 * @description:
 * @date : Created in 2023/4/13 10:22
 */
public class WrapperItem {

    public int id;
    public String itemName;
    public Wrapper<User> owner;
}
