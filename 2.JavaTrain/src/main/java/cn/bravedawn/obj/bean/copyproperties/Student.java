package cn.bravedawn.obj.bean.copyproperties;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-05 15:38
 */
public class Student extends People{


    private String grade;
    private String className;
    private Address address;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                "age='" + getAge() + '\'' +
                "gender='" + getGender() + '\'' +
                "grade='" + grade + '\'' +
                ", className='" + className + '\'' +
                ", address=" + address +
                "} ";
    }
}
