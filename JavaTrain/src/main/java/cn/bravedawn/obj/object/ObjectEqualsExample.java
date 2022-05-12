package cn.bravedawn.obj.object;

import java.util.Objects;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/5/12 7:38
 */
public class ObjectEqualsExample {

    /**
     * Objects.equals的逻辑是：
     * 1.先判断两个对象是否相等，若是返回true，否则false；若两个参数都为null也返回true
     * 2.若第一个参数不为null，则调用他的equals方法进行判断
     */

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        System.out.println(obj1.equals(obj2)); // false
        System.out.println(Objects.equals(obj1, obj2)); // false

        Object obj3 = obj1;
        System.out.println(obj3.equals(obj1)); // true
        System.out.println(Objects.equals(obj3, obj1)); // true

    }
}
