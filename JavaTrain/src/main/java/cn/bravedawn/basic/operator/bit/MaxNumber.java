package cn.bravedawn.basic.operator.bit;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-03-21 15:48
 */
public class MaxNumber {

    private static long sequence = 0L;


    /**
     * Bit运算的技巧，计算n个bit的最大数值
     */

    public static void main(String[] args) {
        System.out.println("5位bit能够表示的最大数值：" + getMaxNumber(5)); // 31，也就是0,1,2...31
    }

    private static long getMaxNumber(int count) {
        return -1L ^ (-1L << count);
    }
}
