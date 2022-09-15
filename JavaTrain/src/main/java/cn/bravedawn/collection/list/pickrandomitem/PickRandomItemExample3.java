package cn.bravedawn.collection.list.pickrandomitem;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/14 21:39
 */
public class PickRandomItemExample3 {

    /**
     * 选择多个随机元素，重复随机获取一个元素的过程就行，可能会出现重复的元素
     */

    public static void main(String[] args) {
        Random random = new Random();
        List<String> givenList = Arrays.asList("one", "two", "three", "four");

        int numberOfElements = 2;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = random.nextInt(givenList.size());
            String randomElement = givenList.get(randomIndex);
            System.out.println(randomElement);
        }
    }
}
