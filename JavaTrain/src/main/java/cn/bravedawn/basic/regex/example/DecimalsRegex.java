package cn.bravedawn.basic.regex.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/4/25 09:35
 *
 * 小数的正则表达式
 */
public class DecimalsRegex {

    private static final Pattern p = Pattern.compile("(\\d+)(\\.)?(\\d+)?");


    public static void main(String[] args) {
        String s = "1";
        String s2 = "1.0";
        String s3 = "0.1";
        String s4 = "0.0001";

        System.out.println(p.matcher(s).matches());
        System.out.println(p.matcher(s2).matches());
        System.out.println(p.matcher(s3).matches());
        System.out.println(p.matcher(s4).matches());

        Matcher m = p.matcher(s);

    }

}
