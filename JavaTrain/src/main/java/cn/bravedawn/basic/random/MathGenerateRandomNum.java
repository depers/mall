package cn.bravedawn.basic.random;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/14 20:57
 */
public class MathGenerateRandomNum {

    /**
     * 使用Math.random()生成随机数
     */

    public static void main(String[] args) {

        // Math 类的 random 方法将返回一个范围从 0.0（包括）到 1.0（不包括）的 double 值
        double random = Math.random();
        System.out.println(random);

        // 使用Math.random()获取由min和max定义的给定范围内的随机数
        System.out.println(getRandomNumber(1, 10));
    }


    static int getRandomNumber(int min, int max) {
        int randomWithMathRandom = (int) (Math.random() * (max - min) + min);
        return randomWithMathRandom;
    }
}
