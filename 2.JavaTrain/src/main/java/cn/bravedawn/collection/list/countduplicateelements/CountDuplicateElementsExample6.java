package cn.bravedawn.collection.list.countduplicateelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/26 21:52
 */
public class CountDuplicateElementsExample6 {

    /**
     * 计算列表中元素重复数量
     * 方法六：使用 Collectors.groupingBy() 和 Collectors.counting()方法计算
     */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 2));
        System.out.println(countByStreamGroupBy(list));
    }


    public static <T> Map<T, Long> countByStreamGroupBy(List<T> inputList) {
        return inputList.stream().collect(Collectors.groupingBy(k -> k, Collectors.counting()));
    }

}
