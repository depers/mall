package cn.bravedawn.basic.operator.bit;

public class Xor {

    /**
     * 异或
     * 位相同结果为0，位不同结果为1
     * 可以实现两个数的交换
     */

    public static void main(String[] args) {
        System.out.println(0 ^ 0); // 0
        System.out.println(1 ^ 0); // 1
        System.out.println(0 ^ 1); // 1
        System.out.println(1 ^ 1); // 0


        int a = 11;
        int b = -11;

        System.out.println("11的补码：" + Integer.toBinaryString(a));
        System.out.println("-11的补码：" + Integer.toBinaryString(b));
        swap(a, b);
    }


    private static void swap(int a, int b) {
        System.out.println("交换前：a=" + a + ", b=" + b);
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println("交换后：a=" + a + ", b=" + b);
    }

}
