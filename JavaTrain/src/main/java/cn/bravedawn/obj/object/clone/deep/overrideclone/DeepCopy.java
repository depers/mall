package cn.bravedawn.obj.object.clone.deep.overrideclone;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/19 21:21
 */
public class DeepCopy {

    /**
     * 深拷贝方法二：覆写clone方法
     * Object父类有个clone()的拷贝方法，不过它是protected类型的，我们需要重写它并修改为public类型。
     * 除此之外，子类还需要实现Cloneable接口来告诉JVM这个类是可以拷贝的。
     * 在下面的打印输出中可以看到teacher是不同的引用地址
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
