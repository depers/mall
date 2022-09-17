package cn.bravedawn.collection.list.removenull;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/16 9:04
 */
public class RemoveNullExample {

    /**
     * 使用Java原生提供的方法去移除null元素，会直接修改原list
     */

    public static void main(String[] args) {
        // 方法一：使用list.remove()
        List<Integer> list = Lists.newArrayList(null, 1, null);
        System.out.println(list); // [null, 1, null]
        while (list.remove(null));

        System.out.println(list); // [1]

        // 方法二：使用Collection.singleton()创建不可变对象
        List<Integer> list2 = Lists.newArrayList(null, 1, null);
        System.out.println(list2); // [null, 1, null]
        // 返回只包含指定对象的不可变集合
        list2.removeAll(Collections.singleton(null));
        System.out.println(list2); // [1]
    }
}
