package cn.bravedawn.generic.wildcards.upperbounds.v2;

import java.util.Arrays;
import java.util.List;

public class GenericsExample <T>{

    public static void main(String[] args) {

        // list of Integers
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(sum(ints));

        // list of double
        List<Double> doubles = Arrays.asList(1.5d, 3d, 2d);
        System.out.println(sum(doubles));

        List<String> strings = Arrays.asList("1", "2");
        //System.out.println(sum(strings)); compile error

    }


    private static Number sum(List<? extends Number> numbers) {
        double s = 0.0;
        for (Number n : numbers) {
            s += n.doubleValue();
        }
        return s;
    }
}
