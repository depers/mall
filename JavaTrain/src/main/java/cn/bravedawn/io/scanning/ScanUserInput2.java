package cn.bravedawn.io.scanning;

import java.util.Scanner;

public class ScanUserInput2 {

    /**
     * 通过hasNextLine读取用户的输入的字符串
     */


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // nextLine方式接收字符串
        System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        while (scan.hasNextLine()) {
            String str2 = scan.nextLine();
            System.out.println("输入的数据为：" + str2);
        }
        scan.close();
    }
}
