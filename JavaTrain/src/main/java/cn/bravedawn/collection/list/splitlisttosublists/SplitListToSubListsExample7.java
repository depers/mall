package cn.bravedawn.collection.list.splitlisttosublists;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/21 20:05
 */
public class SplitListToSubListsExample7 {

    /**
     * 使用Java8 按分隔符拆分列表
     * 下面这段代码的分隔符是0，将他拆分成了三部分，我们最后输出了第三块内容
     */

    public static void main(String[] args) {
        List<Integer> intList = Lists.newArrayList(1, 2, 3, 0, 4, 5, 6, 0, 7, 8);

        // 获取-1，第一个0的下标，第二个0的下标，原列表的长度
        int[] indexes =
                Stream.of(IntStream.of(-1),
                          IntStream.range(0, intList.size()).filter(i -> intList.get(i) == 0),
                          IntStream.of(intList.size()))
                        .flatMapToInt(s -> s).toArray();
        System.out.println(Arrays.toString(indexes)); // [-1, 3, 7, 10]

        // 按照下标数数组拆分原列表
        List<List<Integer>> subSets = IntStream.range(0, indexes.length - 1)
                .mapToObj(i -> intList.subList(indexes[i] + 1, indexes[i + 1]))
                .collect(Collectors.toList());

        System.out.println(subSets); // [[1, 2, 3], [4, 5, 6], [7, 8]]
        List<Integer> lastPartition = subSets.get(2);
        System.out.println(lastPartition); // [7, 8]
    }
}
