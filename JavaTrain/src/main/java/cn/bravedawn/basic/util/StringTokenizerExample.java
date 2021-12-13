package cn.bravedawn.basic.util;

import java.util.StringTokenizer;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2021/12/12 16:30
 */
public class StringTokenizerExample {


    public static void main(String[] args) {
        String str = "feng,xiao";
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",", true);
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }
    }
}
