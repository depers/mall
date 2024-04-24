package cn.bravedawn.generic.genericarray;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * 创建泛型数组的方法
 * 1.通过Array.newInstance()方法，但是需要强转
 * 2.通过可变参数创建泛型数组
 */

public class ArrayHelper {

    /**
     * 借助 Class<T>来创建泛型数组
     * @param cls
     * @param size
     * @return
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] createArray(Class<T> cls, int size) {
        return (T[]) Array.newInstance(cls, size);
    }

    /**
     * 使用可变参数创建泛型数组
     * @param objects
     * @return
     * @param <T>
     */
    public static <T> T[] asArray(T... objects) {
        return objects;
    }


    static <K> K[] pickTwo(K k1, K k2, K k3) {
        return asArray(k1, k2);
    }


    public static void main(String[] args) {
        String[] arr = asArray("one", "two", "three");
        String[] arr2 = createArray(String.class, 3);
        arr2[0] = "one";
        arr2[1] = "two";
        arr2[2] = "three";
        String[] arr3 = pickTwo("one", "two", "three");


        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

        // 这里会报ClassCastException，因为擦拭法，在pickTwo()方法内部，编译器无法检测K[]的正确类型，因此返回了Object[]，无法强转为String[]，所以报错
        System.out.println(Arrays.toString(arr3));
    }
}
