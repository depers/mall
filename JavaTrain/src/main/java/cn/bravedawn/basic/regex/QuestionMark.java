package cn.bravedawn.basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/20 21:11
 */
public class QuestionMark {

    /**
     * ?可表示非贪婪匹配
     * (\d+?) 这里?的意思就是尽可能少的匹配数字，正则表达式默认使用贪婪匹配：任何一个规则，它总是尽可能多地向后匹配
     */


    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d+?)(0*)");
        Matcher m = p.matcher("123000");
        if (m.matches()) {
            System.out.println("group1=" + m.group(1));
            System.out.println("group2=" + m.group(2));
        }
    }
}
