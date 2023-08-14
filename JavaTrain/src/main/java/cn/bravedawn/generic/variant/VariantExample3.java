package cn.bravedawn.generic.variant;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/8/14 22:09
 */
public class VariantExample3 {


    /**
     * 高级面试题，这行代码哪一行会出错，并解释原因
     */

    public static void main(String[] args) {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(12);
    }
}
