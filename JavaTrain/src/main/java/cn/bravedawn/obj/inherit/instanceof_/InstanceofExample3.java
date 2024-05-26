package cn.bravedawn.obj.inherit.instanceof_;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/5/24 15:29
 */
public class InstanceofExample3 {

    /**
     * 可以通过 this instanceof 来判断是哪个子类调用了父类的方法
     */

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.print();
    }
}
