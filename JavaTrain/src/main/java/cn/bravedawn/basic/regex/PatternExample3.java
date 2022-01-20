package cn.bravedawn.basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/20 21:30
 */
public class PatternExample3 {

    /**
     * 搜索字符串
     */

    public static void main(String[] args) {
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(sub);
        }
    }
}
