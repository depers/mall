package cn.bravedawn.basic.lang.long_;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/7/8 16:34
 *
 * long类型的比较建议使用equals方法
 */
public class LongExample2 {

    public static void main(String[] args) {
        Long a = 1l;
        Long b = 1l;

        System.out.println(a == b);
        System.out.println(a.equals(b));

        Long c = 300L;
        Long d = 300L;
        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println(c);
        System.out.println(d);
    }
}
