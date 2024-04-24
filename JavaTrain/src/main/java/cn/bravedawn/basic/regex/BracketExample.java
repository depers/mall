package cn.bravedawn.basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/20 17:30
 */
public class BracketExample {


    /**
     * 使用String.matches()方法匹配正则，不推荐使用这个方法，这样会导致多次创建相同的Pattern对象。其内部实现也是通过
     *  Pattern p = Pattern.compile(regex);
     *  Matcher m = p.matcher(input);
     *  return m.matches();
     *  来实现的
     */

    public static void main(String[] args) {
        String re = "learn\\s(java|php|go)";

        System.out.println("learn java".matches(re));
        System.out.println("learn Java".matches(re));
        System.out.println("learn php".matches(re));
        System.out.println("learn Go".matches(re));

        Matcher m = Pattern.compile(re).matcher("learn go");
        if (m.matches()) {
            System.out.println(m.group(1));
        }
    }
}
