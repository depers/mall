package cn.bravedawn.collection.list.removenull;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/16 11:09
 */
public class RemoveNullExample4 {

    /**
     * 使用Java8 Lambda移除null元素
     */

    public static void main(String[] args) {
        // 方法一：并行移除
        List<Integer> list = Lists.newArrayList(null, 1, 2, null, 3, null);
        List<Integer> listWithoutNulls = list.parallelStream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        System.out.println(listWithoutNulls); // [1, 2, 3]

        // 方法二：串行移除
        List<Integer> list2 = Lists.newArrayList(null, 1, 2, null, 3, null);
        List<Integer> listWithoutNulls2 = list2.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        System.out.println(listWithoutNulls2); // [1, 2, 3]

        // 使用list.removeIf()方法
        List<Integer> list3 = Lists.newArrayList(null, 1, 2, null, 3, null);
        list3.removeIf(Objects::isNull);
        System.out.println(list3); // [1, 2, 3]
    }
}
