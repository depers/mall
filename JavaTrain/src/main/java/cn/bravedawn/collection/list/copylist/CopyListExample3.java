package cn.bravedawn.collection.list.copylist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/19 13:14
 */
public class CopyListExample3 {

    /**
     * 拷贝列表中的元素到另一个列表：第三种方法使用Collections.copy()方法
     */

    public static void main(String[] args) {

        // 长度一致，source中的元素会按照下标顺序覆盖目标列表
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Integer> dest = Arrays.asList(4, 5, 6);
        Collections.copy(dest, source);
        System.out.println("dest = " + dest); // [1, 2, 3]


        // 长度不一致，source中的元素会按照下标顺序覆盖目标列表，目标列表其余元素不变
        List<Integer> source2 = Arrays.asList(1, 2, 3);
        List<Integer> dest2 = Arrays.asList(4, 5, 6, 7, 8, 9, 10);
        Collections.copy(dest2, source2);
        System.out.println("dest2 = " + dest2); // [1, 2, 3, 7, 8, 9, 10]
    }
}
