package cn.bravedawn.basic.lang.string;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-11 15:27
 */
public class StringExample9 {


    public static void main(String[] args) {
        String str = "rpc/2023/09/result_I.xlsx";

        System.out.println(str.substring(0, str.lastIndexOf("I")));

        System.out.println(str.substring(0, str.lastIndexOf("/") + 1));
    }
}
