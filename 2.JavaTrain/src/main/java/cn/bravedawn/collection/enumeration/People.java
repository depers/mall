package cn.bravedawn.collection.enumeration;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/1/11 20:42
 */
public class People {

    private String firstName;
    private String lastName;

    public People(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
