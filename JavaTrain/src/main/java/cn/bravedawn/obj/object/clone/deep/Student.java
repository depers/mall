package cn.bravedawn.obj.object.clone.deep;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/19 17:09
 */
public class Student implements Cloneable{

    private String name;
    private int age;
    private Teacher teacher;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student(String name, int age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 深复制
        Student student = (Student) super.clone();
        student.setTeacher((Teacher) student.getTeacher().clone());
        return student;
    }
}
