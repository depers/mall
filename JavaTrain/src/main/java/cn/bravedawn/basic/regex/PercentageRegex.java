package cn.bravedawn.basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/4/24 17:11
 */
public class PercentageRegex {

    private static final Pattern p = Pattern.compile("(\\d+)(\\.)?(\\d+)?%");


    public static void main(String[] args) {
        String s = "20%";
        String s2 = "21.2%";
        String s3 = "0.01%";
        String s4 = "0.1";

        System.out.println("s是否匹配：" + p.matcher(s).matches());
        System.out.println("s2是否匹配：" + p.matcher(s2).matches());
        System.out.println("s3是否匹配：" + p.matcher(s3).matches());
        System.out.println("s4是否匹配：" + p.matcher(s4).matches());


        Matcher m3 = p.matcher(s3);
        if (m3.find()) {
            System.out.println(m3.groupCount());
            System.out.println(m3.group(1));
            System.out.println(m3.group(2));
            System.out.println(m3.group(3));
        }



    }
}
