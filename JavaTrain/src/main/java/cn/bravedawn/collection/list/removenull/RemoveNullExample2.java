package cn.bravedawn.collection.list.removenull;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/16 9:56
 */
public class RemoveNullExample2 {

    /**
     * 使用Guava移除null元素
     */

    public static void main(String[] args) {
        // 移除null会修改原列表
        List<Integer> list = Lists.newArrayList(null, 1, null);
        Iterables.removeIf(list, Predicates.isNull());
        System.out.println(list); // [1]

        // 移除null不修改原列表
        List<Integer> list2 = Lists.newArrayList(null, 1, null, 2, 3);
        List<Integer> listWithoutNulls = Lists.newArrayList(Iterables.filter(list2, Predicates.notNull()));
        System.out.println(list2); // [null, 1, null, 2, 3]
        System.out.println(listWithoutNulls); // [1, 2, 3]
    }
}
