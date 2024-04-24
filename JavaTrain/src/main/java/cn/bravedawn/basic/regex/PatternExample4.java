package cn.bravedawn.basic.regex;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/20 21:33
 */
public class PatternExample4 {

    /**
     * 替换字符串
     */

    public static void main(String[] args) {
        String s = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
        String r = s.replaceAll("\\s+", " ");
        System.out.println(r); // "The quick brown fox jumps over the lazy dog."
    }
}
