package cn.bravedawn.basic.keyword.static_.staticmethod;

/**
 * @Description : 静态方法演示
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-09-21 11:46
 */
public class Student {

    private int rollNo;
    private String name;
    private static String college = "ITS";

    // 静态方法
    public static void change() {
        college = "BBDIT";
    }

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Student s1 = new Student(101, "小明");
        s1.display();
        Student.change();
        Student s2 = new Student(102, "小美");
        s2.display();
    }


}
