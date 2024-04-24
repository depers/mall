package cn.bravedawn.basic.operator.bit;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-03-21 15:57
 */
public class AvoidOverflow {

    /**
     * 避免的位数溢出，也就是x = (x + 1) & (-1L ^ (-1L << N))能保证最终得到的x值不会超过N，这是利用了按位与中的"取指定位"的特性。
     * 在下面的例子中5位bit最多只能表示数字31，如果超高这个值会被截断
     */

    private static long sequence = 32;

    public static void main(String[] args) {
        System.out.println(getAvoidOverflow(5));
        System.out.println(getAvoidOverflow(5));
        System.out.println(getAvoidOverflow(5));

    }



    private static long getAvoidOverflow(int count) {
        long sequenceMask = -1L ^ (-1L << count);
        System.out.println("sequenceMask=" + sequenceMask);
        sequence = (sequence + 1) & sequenceMask;
        return sequence;
    }
}
