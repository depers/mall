package cn.bravedawn.other.hutool.bean;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/6/16 15:24
 */
public class StudentPeople {

    private String name;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentPeople{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
