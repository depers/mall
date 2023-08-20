package cn.bravedawn.java8.methodandcontructorreferences;

import cn.bravedawn.java8.functionalinterfaces.Converter;

public class MethodReferencesExample2 {


    /**
     * something::startsWith就是对象方法引用，可以进一步简化代码
     */

    public static void main(String[] args) {
        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("Java");
        System.out.println(converted);
    }

    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }
}
