package cn.bravedawn.basic.lang;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/12 20:42
 */
public class FloatingNumForceTypeTransition {

    /**
     * 浮点数的类型强转
     */

    public static void main(String[] args) {
        // 浮点数的小数部分会被丢掉
        int n1 = (int) 12.3;            // 12
        int n2 = (int) 12.7;            // 12
        int n3 = (int) -12.7;           // -12

        // 四舍五入需要加0.5
        int n5 = (int) (12.7 + 0.5);    // 13

        // 如果转型后超过了整型能表示的最大范围，将返回整型的最大值
        int n6 = (int) 1.2e20;          // 2147483647

    }
}
