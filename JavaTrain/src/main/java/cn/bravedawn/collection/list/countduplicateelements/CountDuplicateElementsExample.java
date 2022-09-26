package cn.bravedawn.collection.list.countduplicateelements;

import java.util.*;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/26 21:19
 */
public class CountDuplicateElementsExample {


    /**
     * 计算列表中元素重复数量
     * 方法一：该实现兼容所有的Java版本
     */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 2));
        System.out.println(countByClassicalLoop(list));
    }


    public static <T> Map<T, Long> countByClassicalLoop(List<T> inputList) {
        Map<T, Long> resultMap = new HashMap<>();
        for (T element : inputList) {
            if (resultMap.containsKey(element)) {
                resultMap.put(element, resultMap.get(element) + 1L);
            } else {
                resultMap.put(element, 1L);
            }
        }
        return resultMap;
    }

}
