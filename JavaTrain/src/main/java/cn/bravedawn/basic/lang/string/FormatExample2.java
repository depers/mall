package cn.bravedawn.basic.lang.string;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/5/19 11:16
 */
public class FormatExample2 {

    /**
     * 针对不同类型的变量进行字符串的格式化输出
     */

    public static void main(String[] args) {
        String str1 = String.format("%d", 101);          // Integer value
        String str2 = String.format("%s", "Amar Singh"); // String value
        String str3 = String.format("%f", 101.00);       // Float value
        String str4 = String.format("%x", 101);          // Hexadecimal value
        String str5 = String.format("%c", 'c');          // Char value
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
    }
}
