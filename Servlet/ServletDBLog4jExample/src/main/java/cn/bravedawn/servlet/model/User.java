package cn.bravedawn.servlet.model;

/**
 * @author : depers
 * @program : ServletDBLog4jExample
 * @date : Created in 2022/7/12 22:32
 */
public class User {

    private String name;
    private String email;
    private int id;
    private String country;

    public User(String name, String email, int id, String country) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", country='" + country + '\'' +
                '}';
    }
}
