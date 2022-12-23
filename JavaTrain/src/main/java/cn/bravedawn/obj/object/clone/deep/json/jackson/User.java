package cn.bravedawn.obj.object.clone.deep.json.jackson;


/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/23 22:05
 */
public class User {

    private String name;
    private Address address;

    public User() {
    }

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
