package cn.bravedawn.basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/20 20:40
 */
public class PatternExample {

    /**
     * 只创建一个pattern对象，就可以实现编译一次，多次匹配
     */

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        pattern.matcher("010-12345678").matches(); // true
        pattern.matcher("021-123456").matches(); // false
        pattern.matcher("022#1234567").matches(); // false
        // 获得Matcher对象:
        Matcher matcher = pattern.matcher("010-12345678");
        if (matcher.matches()) {
            String whole = matcher.group(0); // "010-12345678", 0表示匹配的整个字符串
            String area = matcher.group(1); // "010", 1表示匹配的第1个子串
            String tel = matcher.group(2); // "12345678", 2表示匹配的第2个子串
            System.out.println(area);
            System.out.println(tel);
        }
    }
}
