package cn.bravedawn.collection.list.iteratortolist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/14 20:35
 */
public class IteratorToListExample2 {

    /**
     * 在Java8中使用 Iterator的forEachRemaining()方法来实现Iterator转List
     */

    public static void main(String[] args) {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        List<Integer> actualList = new ArrayList<>();
        iterator.forEachRemaining(actualList::add);
        System.out.println(actualList);
    }
}
