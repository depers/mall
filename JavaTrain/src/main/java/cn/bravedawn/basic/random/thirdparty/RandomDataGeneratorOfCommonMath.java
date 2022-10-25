package cn.bravedawn.random.thirdparty;

import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/25 17:28
 */
public class RandomDataGeneratorOfCommonMath {

    /**
     * commons-math3 中提供的随机数生成器
     */


    public static void main(String[] args) {
        int min = 0;
        int max = 100;

        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        int randomWithRandomDataGenerator = randomDataGenerator.nextInt(min, max);
        System.out.println(randomWithRandomDataGenerator);
    }
}
