package cn.bravedawn.java8.stream;

import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/4/29 21:19
 */
public class AllMatchExample {

    /**
     * 检查流中的所有元素是否都满足指定的条件
     */

    public static void main(String[] args) {
        String payMethodsStr = "1,4";
        String[] payMethods = payMethodsStr.split(",");
        boolean b = Arrays.stream(payMethods).allMatch(str -> str.equals("4"));
        System.out.println(b);
    }
}
