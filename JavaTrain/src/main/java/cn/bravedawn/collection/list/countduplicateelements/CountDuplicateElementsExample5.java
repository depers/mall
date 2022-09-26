package cn.bravedawn.collection.list.countduplicateelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/26 21:49
 */
public class CountDuplicateElementsExample5 {

    /**
     * 计算列表中元素重复数量
     * 方法五：使用 Collectors.toMap()方法计算
     */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 2));
        System.out.println(countByStreamToMap(list));
    }


    public static <T> Map<T, Long> countByStreamToMap(List<T> inputList) {
        return inputList.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
    }
}
