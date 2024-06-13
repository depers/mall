package cn.bravedawn.encrypt.encode.ascii;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/6/13 16:01
 */
public class ASCIIExample {

    public static void main(String[] args) {
        // 将Java字符转为ASCII
        // 方法一：将char强制转换为byte
        char ch = 'A';
        byte byteAscii = (byte) ch;
        System.out.println(byteAscii);

        // 方法二：将char直接转化为int，其值就是字符的ascii
        int byteAscii1 = (int) ch;
        System.out.println(byteAscii1);


        // 直接int强制转换为char
        int ascii = 65;
        char ch1 = (char)ascii;
        System.out.println(ch1);

    }
}
