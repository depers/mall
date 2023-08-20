package cn.bravedawn.collection.list.pickrandomitem;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/14 20:53
 */
public class PickRandomItemExample {

    /**
     * 使用Random.next生成随机数，获取List中的随机元素
     * 除此之外，我们也可以使用Math.random()实现
     */


    public static void main(String[] args) {
        List<Integer> givenList = Arrays.asList(1, 2, 3);
        Random rand = new Random();
        int randomElement = givenList.get(rand.nextInt(givenList.size()));
        System.out.println(randomElement);

    }
}
