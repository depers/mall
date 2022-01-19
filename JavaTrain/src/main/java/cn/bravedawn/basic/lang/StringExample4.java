package cn.bravedawn.basic.lang;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: 字符串缓存池
 * @date : Created in 2022/1/11 10:39
 */
public class StringExample4 {

    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2); // false

        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3 == s4); // true

        String s5 = "bbb";
        String s6 = "bbb";
        System.out.println(s5 == s6); // true
    }
}
