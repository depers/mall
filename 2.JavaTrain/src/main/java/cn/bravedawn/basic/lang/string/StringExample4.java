package cn.bravedawn.basic.lang.string;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: 字符串缓存池
 * @date : Created in 2022/1/11 10:39
 */
public class StringExample4 {

    /**
     * 对于任意两个字符串 s 和 t，当且仅当 s.equals(t) 为真时，s.intern() == t.intern() 也为真
     * 从字符串缓存池中返回已存在的equals方法为true的字符串引用
     */

    public static void main(String[] args) {
        // 第一种情况
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2); // false

        // 第二种情况
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3 == s4); // true

        // 第三种情况
        String s5 = "bbb";
        String s6 = "bbb";
        System.out.println(s5 == s6); // true
    }
}
