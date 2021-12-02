package cn.bravedawn.encrypt;

import java.util.Random;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: Random实例
 * @date : Created in 2021/12/1 22:53
 */
public class RandomExample {

    public static void main(String[] args) {
        Random random1 = new Random(123);
        Random random2 = new Random(123);

        System.out.println(random1.nextDouble());
        System.out.println(random2.nextDouble());

    }
}
