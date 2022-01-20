package cn.bravedawn.basic.regex;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/20 21:53
 */
public class PatternExample7 {

    public static void main(String[] args) {
        String s = "Hello, ${name}! You are learning ${lang}!";
        var map = new HashMap<String, String>();
        map.put("name", "Bob");
        map.put("lang", "Java");

        System.out.println(parse(s, map));

    }

    static String parse(String s, Map<String, String> value) {

        for (String key : value.keySet()) {
            Pattern p = Pattern.compile("\\$\\{" + key + "\\}");
            Matcher m = p.matcher(s);
            StringBuilder sb = new StringBuilder();

            while (m.find()) {
                // System.out.println("start:" + m.start() + "," + "end:" + m.end());
                m.appendReplacement(sb, value.get(key));
                // System.out.println(sb);
            }
            s = m.appendTail(sb).toString();
        }

        return s;

    }
}
