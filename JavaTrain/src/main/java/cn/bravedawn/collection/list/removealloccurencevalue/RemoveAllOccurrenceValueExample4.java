package cn.bravedawn.collection.list.removealloccurencevalue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/21 13:16
 */
public class RemoveAllOccurrenceValueExample4 {

    /**
     * 使用Java8 Stream api移除元素
     */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        int valueToElement = 1;
        System.out.println(removeAll(list, valueToElement));
    }

    static List<Integer> removeAll(List<Integer> list, int element) {
        return list.stream().filter(e -> !Objects.equals(e, element)).collect(Collectors.toList());
    }
}
