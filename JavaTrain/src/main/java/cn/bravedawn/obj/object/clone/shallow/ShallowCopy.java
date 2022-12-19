package cn.bravedawn.obj.object.clone.shallow;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/19 17:18
 */
public class ShallowCopy {

    /**
     * 浅拷贝
     * 下面代码中学生的属性对象teacher最后引用的是同一对象
     */

    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher("fengxiao", 28);

        Student student = new Student("xiaoming", 18, teacher);

        Student stu = (Student) student.clone();
        System.out.println("-----拷贝后");
        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getTeacher().getName());
        System.out.println(stu.getTeacher().getAge());

        System.out.println("-----修改老师的信息后");
        teacher.setName("jack");
        System.out.println("student1的老师是：" + student.getTeacher());
        System.out.println("student2的老师是：" + stu.getTeacher());
    }
}
