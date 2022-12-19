package cn.bravedawn.obj.object.clone.quotecopy;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/19 17:04
 */
public class QuoteCopy {

    /**
     * 引用拷贝：
     * 从下面打印输出中可以看到这两个对象指向相同内存地址的同一个对象
     */

    public static void main(String[] args) {
        Teacher teacher = new Teacher("fengxiao", 18);
        Teacher otherTeacher = teacher;
        System.out.println(teacher);
        System.out.println(otherTeacher);
    }
}
