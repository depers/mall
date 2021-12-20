package cn.bravedawn.java8.lambdaexpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionsExample4 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        names.sort((a, b) -> b.compareTo(a));

        names.forEach(name -> System.out.println(name));
    }
}
