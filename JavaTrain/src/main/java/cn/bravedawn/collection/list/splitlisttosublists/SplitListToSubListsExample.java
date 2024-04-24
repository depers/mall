package cn.bravedawn.collection.list.splitlisttosublists;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/15 13:50
 */
public class SplitListToSubListsExample {

    /**
     * 使用Guava获取列表-List的分区（将列表分割为多个子列表）
     */

    public static void main(String[] args) {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> subSets = Lists.partition(intList, 3);

        List<Integer> lastPartition = subSets.get(2);
        System.out.println(lastPartition); // [7, 8]
    }
}
