package cn.bravedawn.basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/19 22:31
 */
public class GroupMatch {

    /**
     * 分组匹配，就是通过(...)符号，使用正则表达式就能直接截取需要的字符串
     */

    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");

        if (m.matches()) {
            String g1 = m.group(1);
            String g2 = m.group(2);

            System.out.println(g1);
            System.out.println(g2);
        } else {
            System.out.println("匹配失败");
        }
    }
}
