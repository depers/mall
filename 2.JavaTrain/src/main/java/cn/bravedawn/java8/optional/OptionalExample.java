package cn.bravedawn.java8.optional;

import java.util.Optional;

public class OptionalExample {

    /**
     * Optioal的常用方法
     *
     * 1.ofNullable()
     * 2.of()
     */

    public static void main(String[] args) {
        Object obj = null;

        // 1.构建一个Optional对象
        Optional<Object> opt = Optional.ofNullable(obj);
        // 是否存在
        System.out.println(opt.isPresent());
        // 是否为空
        System.out.println(opt.isEmpty());

        // 2.构建一个不能为空的Optional对象，若为空会抛空指针异常
        Optional<Object> opt2 = Optional.of(obj);

    }
}
