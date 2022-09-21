package cn.bravedawn.collection.list.removealloccurencevalue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/21 13:21
 */
public class RemoveAllOccurrenceValueExample5 {


    /**
     * 【推荐使用】使用removeIf移除不需要的元素
     */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        int valueToElement = 1;
        removeAll(list, valueToElement);
        System.out.println(list);
    }

    static void removeAll(List<Integer> list, int element) {
        list.removeIf(n -> Objects.equals(n, element));
    }
}
