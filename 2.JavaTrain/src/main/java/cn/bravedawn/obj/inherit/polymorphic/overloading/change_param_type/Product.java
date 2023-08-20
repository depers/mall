package cn.bravedawn.obj.inherit.polymorphic.overloading.change_param_type;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/3 11:25
 */
public class Product {


    // Multiplying three integer values
    public int Prod(int a, int b, int c) {

        int prod1 = a * b * c;
        return prod1;
    }

    // Multiplying three double values.
    public double Prod(double a, double b, double c) {

        double prod2 = a * b * c;
        return prod2;
    }
}
