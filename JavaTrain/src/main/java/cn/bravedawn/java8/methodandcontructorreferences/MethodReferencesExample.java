package cn.bravedawn.java8.methodandcontructorreferences;

import cn.bravedawn.java8.functionalinterfaces.Converter;

public class MethodReferencesExample {


    /**
     * Integer::valueOf就是静态方法引用，可以进一步简化代码
     */

    public static void main(String[] args) {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);
    }
}
