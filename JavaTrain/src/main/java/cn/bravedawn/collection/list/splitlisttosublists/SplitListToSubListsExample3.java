package cn.bravedawn.collection.list.splitlisttosublists;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/15 14:44
 */
public class SplitListToSubListsExample3 {

    /**
     * 使用Guava分区，分区（子列表）是原始集合的子列表视图，这意味着原始集合中的更改将反映在分区中
     */

    public static void main(String[] args) {
        // Given
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = Lists.partition(intList, 3);

        List<Integer> lastPartition = subSets.get(2);
        System.out.println(lastPartition); // [7, 8]

        // 新增一个元素
        intList.add(9);

        // 再次分区
        List<Integer> lastPartition2 = subSets.get(2);
        System.out.println(lastPartition2); // [7, 8, 9]

        // 访问原来的分区会报错
        System.out.println(lastPartition); // java.util.ConcurrentModificationException
    }
}
