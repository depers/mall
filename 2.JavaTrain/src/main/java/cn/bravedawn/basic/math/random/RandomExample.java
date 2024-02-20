package cn.bravedawn.basic.math.random;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/2/19 16:33
 *
 * 生成随机数
 */
public class RandomExample {

    public static void main(String[] args) {
        System.out.println(Math.random());

        System.out.println(getRandom(10, 50));
    }

    /**
     * 获取一个区间内的随机数
     */
    private static long getRandom(double min, double max) {
        double x = Math.random(); // x的范围是[0,1)
        double y = x * (max - min) + min; // y的范围是[min,max)
        long n = (long) y; // n的范围是[min,max)的整数
        return n;
    }
}
