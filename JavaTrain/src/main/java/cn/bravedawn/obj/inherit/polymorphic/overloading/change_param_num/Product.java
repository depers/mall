package cn.bravedawn.obj.inherit.polymorphic.overloading.change_param_num;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/3 11:23
 */
public class Product {

    // Method 1
    // Multiplying two integer values
    public int multiply(int a, int b) {
        int prod = a * b;
        return prod;
    }

    // Method 2
    // Multiplying three integer values
    public int multiply(int a, int b, int c) {
        int prod = a * b * c;
        return prod;
    }
}
