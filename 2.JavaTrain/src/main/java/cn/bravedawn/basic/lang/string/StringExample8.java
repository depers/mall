package cn.bravedawn.basic.lang.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description : 字符串的首字母大小写
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-10-08 14:41
 */
public class StringExample8 {


    public static void main(String[] args) {
        String str = "hello";
        System.out.println(StringUtils.capitalize(str));
        String str1 = "World";
        System.out.println(StringUtils.uncapitalize(str1));
    }
}
