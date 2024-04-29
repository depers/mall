package cn.bravedawn.basic.lang.string.stringjoiner;

import java.util.StringJoiner;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/4/29 21:10
 */
public class StringJoinerExample {

    /**
     * 字符串拼接
     */

    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner("-");
        joiner.add("a");
        joiner.add(null);
        joiner.add("c");
        System.out.println(joiner.toString()); // a-null-c
    }
}
