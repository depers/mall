package cn.bravedawn.collection.list.iteratortolist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/14 20:31
 */
public class IteratorToListExample {

    /**
     * 使用while循环将Iterator转为List
     */

    public static void main(String[] args) {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        List<Integer> actualList = new ArrayList<>();
        while (iterator.hasNext()) {
            actualList.add(iterator.next());
        }
        System.out.println(actualList);
    }
}
