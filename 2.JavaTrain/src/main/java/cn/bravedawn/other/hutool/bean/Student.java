package cn.bravedawn.other.hutool.bean;

public class Student extends People {

    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gender='" + gender + '\'' +
                '}';
    }
}
