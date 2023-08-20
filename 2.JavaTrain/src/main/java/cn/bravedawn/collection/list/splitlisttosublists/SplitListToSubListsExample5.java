package cn.bravedawn.collection.list.splitlisttosublists;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/15 18:46
 */
public class SplitListToSubListsExample5 {

    /**
     * 使用Java8 Collectors.partitioningBy()实现分区
     * 1.生成的分区不是原列表的视图，因此原列表发生的任何更改都不会影响分区
     */
    public static void main(String[] args) {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

        Map<Boolean, List<Integer>> groups =
                intList.stream().collect(Collectors.partitioningBy(s -> s > 6));
        List<List<Integer>> subSets = new ArrayList<>(groups.values());
        List<Integer> lastPartition = subSets.get(1);
        System.out.println(lastPartition); // [7, 8]

        // 添加元素
        intList.add(9);
        List<Integer> lastPartition2 = subSets.get(1);
        System.out.println(groups); // {false=[1, 2, 3, 4, 5, 6], true=[7, 8]}
        System.out.println(lastPartition2); // [7, 8]

    }
}
