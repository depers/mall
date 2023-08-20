package cn.bravedawn.collection.list.pickrandomitem;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/14 21:53
 */
public class PickRandomItemExample5 {

    /**
     * 获得随机的多个元素
     */

    public static void main(String[] args) {
        List<Integer> givenList = Lists.newArrayList(1, 2, 3, 4, 5, 6);

        // 随机打乱列表顺序
        Collections.shuffle(givenList);
        System.out.println(givenList);

        int randomSeriesLength = 3;
        List<Integer> randomSeries = givenList.subList(0, randomSeriesLength);
        System.out.println(randomSeries);
    }
}
