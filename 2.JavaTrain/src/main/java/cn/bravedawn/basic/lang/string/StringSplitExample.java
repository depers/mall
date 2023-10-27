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
        String str = new String("Welcome-to-Runoob");

        System.out.println("- 分隔符返回值 :" );
        for (String retval: str.split("-")){
            System.out.println(retval);
        }


        System.out.println("");
        System.out.println("- 分隔符设置分割份数为正数，分割为2份，返回值 :" );
        for (String retval: str.split("-", 2)){
            System.out.println(retval);
        }

        // 正常分割三次就行，多于3次不会报错
        System.out.println("");
        System.out.println("- 分隔符设置分割份数为正数，分割为4份，超过了可分割份数，返回值 :" );
        for (String retval: str.split("-", 4)){
            System.out.println(retval);
        }

        // limit为0的情况下
        System.out.println();
        System.out.println("limit为0时的情况，分割后的空字符串将会被丢弃：");
        String str2 = new String("a-b-c-d---");
        System.out.println("分割后的数组: " + Arrays.toString(str2.split("-")));
        System.out.println("分割后的数组: " + Arrays.toString(str2.split("-", 0)));


        // 连续多个结尾分隔符会被丢弃
        System.out.println();
        System.out.println("弥补连续多个结尾分隔符会被丢弃情况:");
        System.out.println("limit等于0，分割后的数组: " + Arrays.toString(str2.split("-")));
        System.out.println("limit小于0，分割后的数组: " + Arrays.toString(str2.split("-", -1)));


        System.out.println("");
        String str3 = new String("www.runoob.com");
        System.out.println("转义字符返回值 :" );
        for (String retval: str3.split("\\.", 3)){
            System.out.println(retval);
        }

        System.out.println("");
        String str4 = new String("acount=? and uu =? or n=?");
        System.out.println("多个分隔符返回值 :" );
        for (String retval: str4.split("and|or")){
            System.out.println(retval);
        }
    }
}
