package cn.bravedawn.basic.coreclass.objects;

import java.util.Objects;

public class ObjectsExample {

    /**
     * Objects类的常用方法
     *
     * 1.isNull()
     * 2.requireNonNull()
     * 3.
     *
     */

    public static void main(String[] args) {

        Object obj = null;

        // 判断obj是否为null
        boolean isNull = Objects.isNull(obj);
        System.out.println(isNull);

        // 判断obj是否为null，若是则抛出空指针异常，若不是则原样返回
        Object Object = Objects.requireNonNull(obj);


    }
}
