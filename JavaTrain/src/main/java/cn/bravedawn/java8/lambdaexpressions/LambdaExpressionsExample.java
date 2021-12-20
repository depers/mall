package cn.bravedawn.java8.lambdaexpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressionsExample {

    /**
     * Java8 Lambda表达式的使用
     */

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        names.forEach(name -> System.out.println(name));
    }
}
