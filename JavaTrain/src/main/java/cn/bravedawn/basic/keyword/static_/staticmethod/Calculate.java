package cn.bravedawn.basic.keyword.static_.staticmethod;

/**
 * @Description : 静态方法的演示
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-09-21 11:55
 */
public class Calculate {

    public static int cube(int x) {
        return x * x * x;
    }

    public static void main(String args[]) {
        int result = Calculate.cube(5);
        System.out.println(result);
    }
}
