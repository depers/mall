package cn.bravedawn.basic.enum_;

import java.util.Arrays;

public class EnumExample2 {

    /**
     * 枚举的实例方法
     */


    public static void main(String[] args) {

        // 返回常量名
        String s = Color.RED.name();
        System.out.println(s); // RED

        // 返回定义常量的顺序，从0开始计数
        int order = Color.GREEN.ordinal();
        System.out.println(order); // 2

        // 返回枚举定义的数组
        Color[] arr = Color.values();
        System.out.println(Arrays.toString(arr)); // [RED, BLUE, GREEN]

        // 根据枚举名称解析枚举
        Color val = Color.valueOf("RED");
        System.out.println(val); // RED
    }
}
