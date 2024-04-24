package cn.bravedawn.collection.list.iteratoroverlist;

import java.util.Arrays;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/22 23:00
 */
public class IteratorOverListExample2 {

    /**
     * 方法二：增强的for循环
     */

    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Germany", "Panama", "Australia");
        for (String country : countries) {
            System.out.println(country);
        }
    }
}
