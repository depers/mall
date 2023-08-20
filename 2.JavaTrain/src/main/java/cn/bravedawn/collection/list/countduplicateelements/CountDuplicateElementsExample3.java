package cn.bravedawn.collection.list.countduplicateelements;

import java.util.*;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/26 21:34
 */
public class CountDuplicateElementsExample3 {

    /**
     * 计算列表中元素重复数量
     * 方法三：使用Map.compute()方法计算
     */


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 2));
        System.out.println(countByForEachLoopWithMapCompute(list));
    }

    public static <T> Map<T, Long> countByForEachLoopWithMapCompute(List<T> inputList) {
        Map<T, Long> resultMap = new HashMap<>();
        inputList.forEach(e -> resultMap.compute(e, (k, v) -> v == null ? 1L : v + 1L));
        return resultMap;
    }

}
