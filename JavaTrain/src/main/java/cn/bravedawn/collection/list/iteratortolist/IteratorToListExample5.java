package cn.bravedawn.collection.list.iteratortolist;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/14 20:44
 */
public class IteratorToListExample5 {

    /**
     * 使用 Guava将Iterator转为可变的List
     */

    public static void main(String[] args) {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        List<Integer> actualList = Lists.newArrayList(iterator);
        System.out.println(actualList);
    }
}
