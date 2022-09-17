package cn.bravedawn.collection.list.removeduplicate;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/16 11:27
 */
public class RemoveDuplicateExample2 {

    /**
     * 使用Guava移除重复元素
     */

    public static void main(String[] args) {
        // 无法保证与原列表元素顺序一致
        List<Integer> listWithDuplicates = Lists.newArrayList(5, 0, 3, 1, 2, 3, 0, 0);
        List<Integer> listWithoutDuplicates = Lists.newArrayList(Sets.newHashSet(listWithDuplicates));
        System.out.println(listWithoutDuplicates); // [0, 1, 2, 3, 5]

        // 保证与原列表元素顺序一致
        List<Integer> listWithoutDuplicates2 = Lists.newArrayList(Sets.newLinkedHashSet(listWithDuplicates));
        System.out.println(listWithoutDuplicates2); // [5, 0, 3, 1, 2]
    }
}
