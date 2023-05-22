package cn.bravedawn.basic.operator;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/5/21 16:07
 */
public class RepeatSubtraction {

    /**
     * a++是先用当前值，后加1
     * ++a是先加1，用加1之后的值
     *
     * a--也是先用当前值，后减1
     * --a是先减1，用减1之后的值
     */


    public static void main(String[] args) {
        int a = 2;
        int b = 2;
        System.out.println(a++);
        System.out.println(a);
        System.out.println(++b);
        System.out.println(b);
        System.out.println("---------------");

        int c = 2;
        int d = 2;
        System.out.println(c--);
        System.out.println(c);
        System.out.println(--d);
        System.out.println(d);
    }
}
