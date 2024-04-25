package cn.bravedawn.basic.regex.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/4/25 09:24
 *
 * 分数的正则表达式
 */
public class FractionRegex {

    private static final Pattern p = Pattern.compile("(\\d+)(/)?(\\d+)?");


    public static void main(String[] args) {
        String s = "1/3";
        String s2 = "1.1";
        String s3 = "1";


        System.out.println(p.matcher(s).matches());
        System.out.println(p.matcher(s2).matches());
        System.out.println(p.matcher(s3).matches());


        Matcher m = p.matcher(s);
        if (m.find()) {
            System.out.println(m.groupCount());
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
        }
    }
}
