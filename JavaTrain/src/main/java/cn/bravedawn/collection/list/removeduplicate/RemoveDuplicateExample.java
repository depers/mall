package cn.bravedawn.collection.list.removeduplicate;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/16 11:18
 */
public class RemoveDuplicateExample {

    /**
     * 使用原生Java 移除重复元素
     */

    public static void main(String[] args) {

        // 使用HashSet实现，它是一个无序集合，移除重复元素之后的listWithoutDuplicates顺序可能和原始的listWithDuplicates顺序不同
        List<Integer> listWithDuplicates = Lists.newArrayList(5, 0, 3, 1, 2, 3, 0, 0);
        List<Integer> listWithoutDuplicates = new ArrayList<>(new HashSet<>(listWithDuplicates));

        System.out.println(listWithDuplicates); // [5, 0, 3, 1, 2, 3, 0, 0]
        System.out.println(listWithoutDuplicates); // [0, 1, 2, 3, 5]

        // 使用LinkedList保证移除重复元素后的列表listWithoutDuplicates的元素顺序与listWithDuplicates顺序相同
        List<Integer> listWithoutDuplicates2 = new ArrayList<>(new LinkedHashSet<>(listWithDuplicates));
        System.out.println(listWithoutDuplicates2); // [5, 0, 3, 1, 2]

    }
}
