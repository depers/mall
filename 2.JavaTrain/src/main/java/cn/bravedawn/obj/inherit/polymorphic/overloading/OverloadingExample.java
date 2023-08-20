package cn.bravedawn.obj.inherit.polymorphic.overloading;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/3 11:19
 */
public class OverloadingExample {

    /**
     * 方法重载的示例
     */

    // Overloaded sum(). This sum takes two int parameters
    public int sum(int x, int y) {
        return (x + y);
    }

    // Overloaded sum(). This sum takes three int parameters
    public int sum(int x, int y, int z) {
        return (x + y + z);
    }

    // Overloaded sum(). This sum takes two double
    // parameters
    public double sum(double x, double y) {
        return (x + y);
    }

    // Driver code
    public static void main(String args[]) {
        OverloadingExample s = new OverloadingExample();
        System.out.println(s.sum(10, 20));
        System.out.println(s.sum(10, 20, 30));
        System.out.println(s.sum(10.5, 20.5));
    }
}
