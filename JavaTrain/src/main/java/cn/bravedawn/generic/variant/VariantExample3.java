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
     *
     * Java的数组是支持协变的，所以我们可以将非同一类型的对象添加到数组中。
     * 但是由于下面的数组b根本上是一个String数组，所以会报ArrayStoreException异常
     */

    public static void main(String[] args) {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(12);  // ArrayStoreException
    }

}
