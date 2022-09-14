package cn.bravedawn.collection.list.iteratortolist;

import org.apache.commons.collections4.IteratorUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/14 20:46
 */
public class IteratorToListExample6 {

    /**
     * 使用 Apache commons Collections实现Iterator转为List
     */

    public static void main(String[] args) {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        List<Integer> actualList = IteratorUtils.toList(iterator);
        System.out.println(actualList);
    }
}
