package cn.bravedawn.obj.inherit.polymorphic.overloading.change_param_type;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/3 11:26
 */
public class Test {

    /**
     * 通过改变方法形参的类型来实现方法的重载
     */

    public static void main(String[] args) {
        Product obj = new Product();

        int prod1 = obj.Prod(1, 2, 3);
        System.out.println("Product of the three integer value :" + prod1);
        double prod2 = obj.Prod(1.0, 2.0, 3.0);
        System.out.println("Product of the three double value :" + prod2);
    }

}
