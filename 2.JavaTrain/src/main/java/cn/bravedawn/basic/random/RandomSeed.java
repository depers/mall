package cn.bravedawn.basic.random;

import java.util.Random;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/3 14:52
 */
public class RandomSeed {

    /**
     * 相同种子的Random产生的随机数是相同的
     */

    public static void main(String[] args) {
        Random random = new Random();
        random.setSeed(1l);
        System.out.println(random.nextInt());
    }
}
