package cn.bravedawn.collection.list.countduplicateelements;

import java.util.*;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/26 21:41
 */
public class CountDuplicateElementsExample4 {

    /**
     * 计算列表中元素重复数量
     * 方法四：使用 Map.merge()方法计算
     */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 2));
        System.out.println(countByEachLoopWithMapMerge(list));
    }


    /**
     * merge()是如何工作的：
     *      如果给定键的映射不存在，或者它的值为空，则它将键与提供的值相关联。
     *      否则，它使用重映射函数计算一个新值并相应地更新映射。
     */
    public static <T> Map<T, Long> countByEachLoopWithMapMerge(List<T> inputList) {
        Map<T, Long> resultMap = new HashMap<>();
        inputList.forEach(e -> resultMap.merge(e, 1L, Long::sum));
        return resultMap;
    }



}
