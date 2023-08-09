package cn.bravedawn.java8.optional;

import com.google.common.base.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Integer value1 = null;
        Integer value2 = new Integer(10);

        Optional<Integer> a = Optional.fromNullable(value1);

        Optional<Integer> b = Optional.of(value2);



    }


    public static Integer sun(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("第一个参数值是否存在：" + a.isPresent());
        System.out.println("第二个参数值是否存在："+ b.isPresent());

        Integer val = a.
    }
}
