package cn.bravedawn.collection.list.pickrandomitem;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/14 21:44
 */
public class PickRandomItemExample5 {

    /**
     * 选择多个随机元素，不会出现重复的元素
     */

    public static void main(String[] args) {
        Random random = new Random();
        // 和PickRandomItemExample4相区别，这里实例化List用的Lists.newArrayList，因为Arrays.ArrayList的不支持remove操作
        List<String> givenList = Lists.newArrayList("one", "two", "three", "four");

        int numberOfElements = 2;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = random.nextInt(givenList.size());
            String randomElement = givenList.get(randomIndex);
            System.out.println(randomElement);
            // 选中之后进行移除
            givenList.remove(randomIndex);
        }
    }
}
