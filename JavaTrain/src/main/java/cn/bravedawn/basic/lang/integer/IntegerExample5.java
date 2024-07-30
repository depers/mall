package cn.bravedawn.basic.lang.integer;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/7/25 11:35
 */
public class IntegerExample5 {

    public static void main(String[] args) {
        int a = 1025;
        int b = 24;

        int a2 = a;
        int b2 = b;

        a = 1024;
        b = 23;

        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("a2=" + a2);
        System.out.println("b2=" + b2);
    }
}
