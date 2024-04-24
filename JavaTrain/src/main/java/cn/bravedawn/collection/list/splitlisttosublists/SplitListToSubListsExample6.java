package cn.bravedawn.collection.list.splitlisttosublists;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/21 19:59
 */
public class SplitListToSubListsExample6 {

    /**
     * 使用Java8 Collectors.groupingBy() 实现分区
     * 2.生成的分区不是原列表的视图，因此原列表发生的任何更改都不会影响分区
     */

    public static void main(String[] args) {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        Map<Integer, List<Integer>> groups = intList.stream().collect(Collectors.groupingBy(s -> (s - 1) / 3));

        List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values());
        List<Integer> lastPartition = subSets.get(2);
        System.out.println(lastPartition); // [7, 8]

        // 添加元素
        intList.add(9);
        List<Integer> lastPartition2 = subSets.get(2);
        System.out.println(intList); // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(lastPartition2); // [7, 8]
    }
}
