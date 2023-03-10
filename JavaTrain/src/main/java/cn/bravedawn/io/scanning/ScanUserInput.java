package cn.bravedawn.io.scanning;

import java.util.Scanner;

public class ScanUserInput {

    /**
     * 使用next方式读取用户的键盘输入的字符串，并进行输出
     */


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入

        System.out.println("你输入的内容有：");
        while (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }
}
