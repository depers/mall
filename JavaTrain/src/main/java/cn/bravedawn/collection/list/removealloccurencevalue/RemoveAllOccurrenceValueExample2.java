package cn.bravedawn.collection.list.removealloccurencevalue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/20 19:20
 */
public class RemoveAllOccurrenceValueExample2 {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        int valueToElement = 1;
        removeAll(list, valueToElement);

    }

    /**
     * 实验一：使用for循环来移除元素
     * 实验过程：
     *      这里会遇到RemoveAllOccurrenceValueExample实验一中类似的情况
     */
    static void removeAll(List<Integer> list, int element) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(element, list.get(i))) {
                list.remove(element);
            }
        }
    }



}
