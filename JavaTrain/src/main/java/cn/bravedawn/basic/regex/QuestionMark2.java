package cn.bravedawn.basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/20 21:15
 */
public class QuestionMark2 {

    /**
     * 在正则表达式中?的两重含义：
     * 1. ?可以匹配0个或一个字符
     * 2. ?是尽可能少的匹配数字
     *
     * 如果是??的含义就是0个字符
     */

    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d??)(9*)");
        Pattern p2 = Pattern.compile("(\\d?)(9*)");

        Matcher m = p.matcher("9999");
        Matcher m2 = p2.matcher("9999");

        if (m.matches()) {
            System.out.println("??的情况");
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }

        if (m2.matches()) {
            System.out.println("?的情况");
            System.out.println(m2.group(1));
            System.out.println(m2.group(2));
        }

    }
}
