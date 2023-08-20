package cn.bravedawn.basic.lang;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: 进制转换
 * @date : Created in 2022/1/11 8:33
 */
public class SysConvertExample {

    public static void main(String[] args) {
        // 10进制
        System.out.println(Integer.toString(100));

        // 36进制
        System.out.println(Integer.toString(100, 36));

        // 16进制，以0x开始的数据表示16进制
        System.out.println(Integer.toHexString(100));
        System.out.println(Integer.toString(100, 16));

        // 8进制
        System.out.println(Integer.toOctalString(100));
        System.out.println(Integer.toString(100, 8));

        // 2进制
        System.out.println(Integer.toBinaryString(100));
        System.out.println(Integer.toString(100, 2));

        // 负数以其正值的补码形式表达
        System.out.println("二进制：" + Integer.toBinaryString(100));
        System.out.println("反码：" + Integer.toBinaryString(~100));
        System.out.println("补码：" + Integer.toBinaryString(-100));

        // 将16进制转换为10进制
        System.out.println("将16进制转换为10进制：" + decToHex("0x10000"));
    }


    public static int decToHex(String val) {
        if (val.startsWith("0x") || val.startsWith("0X")) {
            val = val.substring(2);
        }

        return Integer.parseInt(val, 16);


    }
}
