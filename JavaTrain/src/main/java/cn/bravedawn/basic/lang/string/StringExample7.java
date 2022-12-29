package cn.bravedawn.basic.lang.string;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/29 22:01
 */
public class StringExample7 {

    /**
     * 判断String开头字母是否为某个字符
     */

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str.substring(0, 1).equals("a"));

        System.out.println(str.startsWith("a"));
    }
}
