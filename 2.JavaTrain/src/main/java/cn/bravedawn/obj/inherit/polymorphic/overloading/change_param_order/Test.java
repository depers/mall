package cn.bravedawn.obj.inherit.polymorphic.overloading.change_param_order;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/3 11:37
 */
public class Test {

    /**
     * 通过改变参数的排列顺序来实现重载
     */

    public static void main(String[] args) {
        // Creating object of above class
        Student obj = new Student();

        // Passing name and id
        // Note: Reversing order
        obj.StudentId("Spyd3r", 1);
        obj.StudentId(2, "Kamlesh");
    }
}
