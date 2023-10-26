package cn.bravedawn.collection.list.splitlisttosublists;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/15 14:27
 */
public class SplitListToSubListsExample2 {

    /**
     * 使用Guava获取集合-Collection的分区（将列表分割为多个子集合）
     */

    public static void main(String[] args) {
        Collection<Integer> intCollection = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

        Iterable<List<Integer>> subSets = Iterables.partition(intCollection, 5);

        List<Integer> firstPartition = subSets.iterator().next();
        System.out.println(firstPartition); // [1, 2, 3]
    }
}
