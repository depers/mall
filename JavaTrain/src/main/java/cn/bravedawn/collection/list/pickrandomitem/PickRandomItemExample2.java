package cn.bravedawn.collection.list.pickrandomitem;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/14 21:23
 */
public class PickRandomItemExample2 {

    /**
     * 使用单个Random类编写多线程程序时，可能会导致访问此实例的每个线程选择相同的值
     * 这里使用专用的 ThreadLocalRandom 类为每个线程创建一个新实例，避免选择相同的值
     */

    public static void main(String[] args) {
        List<Integer> givenList = Arrays.asList(1, 2, 3);
        int randomElementIndex = ThreadLocalRandom.current().nextInt(givenList.size());
        System.out.println(givenList.get(randomElementIndex));
    }
}
