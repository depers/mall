package cn.bravedawn.basic.operator.bit;

public class Xor {

    /**
     * 异或
     * 参考文章：https://www.baeldung.com/java-xor-operator
     */

    public static void main(String[] args) {
        int positiveValue = 12;
        int negativeValue = -12;
        System.out.println(Integer.toBinaryString(positiveValue));
        System.out.println(Integer.toBinaryString(negativeValue));
    }
}
