package cn.bravedawn.collection.list.removeduplicate;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/16 11:35
 */
public class RemoveDuplicateExample3 {

    /**
     * 使用Java stream distinct()移除重复元素
     */

    public static void main(String[] args) {
        /**
         * distinct()方法返回的是一个与原列表顺序一致的列表
         */
        List<Integer> listWithDuplicates = Lists.newArrayList(5, 0, 3, 1, 2, 3, 0, 0);
        List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listWithoutDuplicates); // [5, 0, 3, 1, 2]
    }
}
