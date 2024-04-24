package cn.bravedawn.basic.keyword.static_.staticvariable;

/**
 * @Description : 静态变量的演示代码
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-09-21 11:25
 */
public class Student {

    /**
     * 如果我们改变类变量的值，那么所有类对象的静态变量的值都会发生变化
     */

    private int rollNo;
    private String name;
    private static String college = "ITS";


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
        Student s2 = new Student(102, "小美");

        s1.display();
        s2.display();
        System.out.println("---------------------");
        Student.college = "BBDIT";
        s1.display();
        s2.display();
    }
}
