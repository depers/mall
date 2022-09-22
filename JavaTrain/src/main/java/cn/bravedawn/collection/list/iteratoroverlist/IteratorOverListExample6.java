package cn.bravedawn.collection.list.iteratoroverlist;

import java.util.Arrays;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/22 23:13
 */
public class IteratorOverListExample6 {

    /**
     * 方法六：使用Stream.foreach()
     */

    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Germany", "Panama", "Australia");
        countries.stream().forEach(c -> System.out.println(c));
    }
}
