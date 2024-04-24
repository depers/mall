package cn.bravedawn.java8.lambdaexpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionsExample3 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        names.forEach(name -> System.out.println(name));
    }
}
