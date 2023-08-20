package cn.bravedawn.obj.inherit.polymorphic.overloading.change_param_num;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/3 11:23
 */
public class Test {

    /**
     * 通过改变方法形参的个数来实现方法的重载
     */

    // Main driver method
    public static void main(String[] args) {

        // Creating object of above class inside main()
        // method
        Product ob = new Product();

        // Calling method to Multiply 2 numbers
        int prod1 = ob.multiply(1, 2);

        // Printing Product of 2 numbers
        System.out.println(
                "Product of the two integer value :" + prod1);

        // Calling method to multiply 3 numbers
        int prod2 = ob.multiply(1, 2, 3);

        // Printing product of 3 numbers
        System.out.println(
                "Product of the three integer value :" + prod2);
    }
}
