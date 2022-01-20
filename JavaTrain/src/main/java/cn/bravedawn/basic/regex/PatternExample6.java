package cn.bravedawn.basic.regex;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/20 21:37
 */
public class PatternExample6 {

    /**
     * appendReplacement方法的使用
     */

    public static void main(String[] args) {
        String s = "one cat two cats in the yard";
        Pattern p = Pattern.compile("cat");
        Matcher m = p.matcher(s);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            System.out.println("start:" + m.start() + "," + "end:" + m.end());
            m.appendReplacement(sb, "dog");
            System.out.println(sb);
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }



}
