package cn.bravedawn.basic.random;

import java.util.Random;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/14 21:07
 */
public class RandomNextInt {

    /**
     * 使用Random.next()生成随机数
     */

    public static void main(String[] args) {
        Random random = new Random();

        // 使用无参的nextInt方法可以获取任何随机数，经常会拿到负数
        int randomWithNextInt = random.nextInt();
        System.out.println(randomWithNextInt);

        // 使用有参的nextInt方法，可以得到一个范围内的数字
        System.out.println(getRandomNumber(0, 10));
    }

    static int getRandomNumber(int min, int max) {
        Random random = new Random();
        // nextInt(n)，生成一个在0(包括)到n(不包括)之间的一个数，带参数的方法中，n必须大于0，否则就会报IllegalArgumentException
        int randomWithNextIntWithARange = random.nextInt(max - min) + min;
        return randomWithNextIntWithARange;
    }
}
