package cn.bravedawn.basic.lang.integer;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-07 09:31
 */
public class NumberOfLeadingZerosExample {

    /**
     * Integer的numberOfLeadingZeros()方法的使用
     * 该方法返回无符号整数i的最高非0位前面的0的个数，如果i为负数，这个方法将会返回0，符号位为1。
     *  java的整型长度为32位。那么这个方法返回的就是28
     */

    public static void main(String[] args) {
        int a = 15;
        int b = -15;
        int c = 0;

        System.out.println(a + "的二级制数是：" + Integer.toBinaryString(a));
        System.out.println(a + "的最高非0位前面的0的个数：" + Integer.numberOfLeadingZeros(a));

        System.out.println(b + "的二级制数是：" + Integer.toBinaryString(b));
        System.out.println(b + "的最高非0位前面的0的个数：" + Integer.numberOfLeadingZeros(b));

        System.out.println(c + "的二级制数是：" + Integer.toBinaryString(c));
        System.out.println(c + "的最高非0位前面的0的个数：" + Integer.numberOfLeadingZeros(c));
    }
}
