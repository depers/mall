package cn.bravedawn.collection.list.arraylist;

import com.google.common.collect.ImmutableList;
import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/13 18:39
 */
public class ImmutableArrayListExample {

    /**
     * 创建不可变列表的五种实现
     */

    public static void main(String[] args) {
        // 方法一：使用JDK提供了可以从现有集合中获取不可修改集合的方法
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        // unmodifiableList.add("four"); // java.lang.UnsupportedOperationException

        // 方法二：在Java9中提供了List<E>.of(E… elements)静态工厂方法，来创建不可变列表
        List<String> unmodifiableList2 = List.of(list.toArray(new String[]{}));
        // unmodifiableList2.add("four"); // java.lang.UnsupportedOperationException

        // 方法三：Guava提供也提供了创建不可变列表的方法，该操作实际上创建了一个新的副本
        List<String> unmodifiableList3 = ImmutableList.copyOf(list);
        unmodifiableList3.add("four"); // java.lang.UnsupportedOperationException

        // 方法四：Guava还提供了一个构造器，返回强类型的ImmutableList，而不是简单的List
        ImmutableList<String> unmodifiableList4 = ImmutableList.<String>builder().addAll(list).build();
        // unmodifiableList4.add("four"); // java.lang.UnsupportedOperationException

        // 方法五：Apache Collections Commons提供了创建不可变列表的方法
        List<String> unmodifiableList5 = ListUtils.unmodifiableList(list);
        // unmodifiableList5.add("four"); // java.lang.UnsupportedOperationException

    }
}
