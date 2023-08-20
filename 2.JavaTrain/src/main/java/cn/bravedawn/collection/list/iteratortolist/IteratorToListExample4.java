package cn.bravedawn.collection.list.iteratortolist;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/14 20:42
 */
public class IteratorToListExample4 {

    /**
     * 使用 Guava 实现 Iterator 转为不可变的 List
     */

    public static void main(String[] args) {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        List<Integer> actualList = ImmutableList.copyOf(iterator);
        System.out.println(actualList);
    }
}
