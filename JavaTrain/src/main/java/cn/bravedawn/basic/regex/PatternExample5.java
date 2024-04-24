package cn.bravedawn.basic.regex;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/20 21:35
 */
public class PatternExample5 {

    /**
     * 反向引用：就是把搜索到的指定字符串按规则进行替换
     */

    public static void main(String[] args) {
        String s = "the quick brown fox jumps over the lazy dog.";
        String r = s.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(r);
    }
}
