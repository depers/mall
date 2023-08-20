package cn.bravedawn.collection.list.iteratortolist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/14 20:37
 */
public class IteratorToListExample3 {

    /**
     * 使用Java8 Stream API实现 Iterator -> (Iterable) -> List
     */

    public static void main(String[] args) {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        Iterable<Integer> iterable = () -> iterator;

        List<Integer> actualList = StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());

        System.out.println(actualList);
    }
}
