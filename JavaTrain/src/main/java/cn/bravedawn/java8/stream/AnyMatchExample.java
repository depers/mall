package cn.bravedawn.java8.stream;

import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2021/12/30 10:29
 */
public class AnyMatchExample {


    public static void main(String[] args) {
        String payMethodsStr = "1,4";
        String[] payMethods = payMethodsStr.split(",");
        boolean b = Arrays.stream(payMethods).anyMatch(method -> method.equals(4));

        System.out.println(b);
    }
}
