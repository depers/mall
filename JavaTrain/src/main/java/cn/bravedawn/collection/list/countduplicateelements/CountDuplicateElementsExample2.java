package cn.bravedawn.collection.list.countduplicateelements;

import java.util.*;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/26 21:28
 */
public class CountDuplicateElementsExample2 {

    /**
     * 计算列表中元素重复数量
     * 方法二：如果不考虑兼容Java8之前的版本，可以使用下面的这个版本
     */


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 2));
        System.out.println(countByForEachLoopWithGetOrDefault(list));
    }

    public static <T> Map<T, Long> countByForEachLoopWithGetOrDefault(List<T> inputList) {
        Map<T, Long> resultMap = new HashMap<>();
        inputList.forEach(e -> resultMap.put(e, resultMap.getOrDefault(e, 0L) + 1));
        return resultMap;
    }
}
