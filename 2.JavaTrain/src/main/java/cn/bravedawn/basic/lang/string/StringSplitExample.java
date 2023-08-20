package cn.bravedawn.basic.lang.string;

import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2022/12/5 19:09
 */
public class StringSplitExample {

    public static void main(String[] args) {
        String str = "";
        String str2 = "12";
        System.out.println(Arrays.toString(str.split(",")));
        System.out.println(Arrays.toString(str2.split(",")));
    }
}
