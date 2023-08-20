package cn.bravedawn.basic.regex;

import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/20 21:27
 */
public class PatternExample2 {

    /**
     * 分割字符串
     */

    public static void main(String[] args) {
        /**
         * "a b c".split("\\s"); // { "a", "b", "c" }
         * "a b  c".split("\\s"); // { "a", "b", "", "c" }
         * "a, b ;; c".split("[\\,\\;\\s]+"); // { "a", "b", "c" }
         */

        System.out.println(Arrays.toString("a b c".split("\\s")));
        System.out.println(Arrays.toString("a b  c".split("\\s")));
        System.out.println(Arrays.toString("a, b ;; c".split("[\\,\\;\\s]+")));
    }
}
