package cn.bravedawn.collection.list.splitlisttosublists;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/15 18:34
 */
public class SplitListToSubListsExample4 {

    /**
     * 使用Apache commons Collections分区，分区（子列表）是原始集合的子列表视图，这意味着原始集合中的更改将反映在分区中
     * @param args
     */

    public static void main(String[] args) {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = ListUtils.partition(intList, 3);

        List<Integer> lastPartition = subSets.get(2);
        System.out.println(lastPartition); // [7, 8]

        // 添加一个元素
        intList.add(9);
        List<Integer> lastPartition2 = subSets.get(2);
        System.out.println(lastPartition2); // [7, 8, 9]
        System.out.println(lastPartition); // java.util.ConcurrentModificationException

    }
}
