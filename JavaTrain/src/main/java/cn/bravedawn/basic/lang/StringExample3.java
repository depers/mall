package cn.bravedawn.basic.lang;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: 字符串基本操作
 * @date : Created in 2022/1/11 10:39
 */
public class StringExample3 {

    public static void main(String[] args) {
        String str = "abcdefg";

        System.out.println(str.equals("123"));
        System.out.println(str.equalsIgnoreCase("123"));

        System.out.println(str.contains("a"));

        System.out.println("  \tHello\r\n ".trim());
        System.out.println("\u3000Hello\u3000".strip());
        System.out.println("  \tHello\r\n ".strip());

        System.out.println(str.charAt(1));

        System.out.println(str.concat("123"));

        System.out.println(String.join("-", "java", "is", "cool"));
    }
}
