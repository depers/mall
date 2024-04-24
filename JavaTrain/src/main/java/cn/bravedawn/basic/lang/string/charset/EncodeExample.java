package cn.bravedawn.basic.lang.string.charset;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-20 14:11
 */
public class EncodeExample {

    /**
     * 因为Java在内存中总是使用Unicode表示字符，所以，一个英文字符和一个中文字符都用一个char类型表示，它们都占用两个字节。
     * 要显示一个字符的Unicode编码，只需将char类型直接赋值给int类型即可
     */


    public static void main(String[] args) {
        char c1 = 'A'; // \u0041
        char c2 = '中'; // \u4e2d
        int i1 = 'A'; // 字母“A”的Unicodde编码是65
        int i2 = '中'; // 汉字“中”的Unicode编码是20013

        System.out.println(i1);
        System.out.println(i2);

        System.out.println(Integer.toHexString(i1));
        System.out.println(Integer.toHexString(i2));
    }
}

