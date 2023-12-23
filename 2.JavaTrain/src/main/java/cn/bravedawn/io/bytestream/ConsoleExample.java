package cn.bravedawn.io.bytestream;

import java.io.Console;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 10:12
 */
public class ConsoleExample {

    /**
     * 由于Scanner类输入是可见的，故Scanner类不适用于从控制台读取密码。从Java se 6开始加入了Console类来解决此问题。
     *
     * Java.io.Console 只能用在标准输入、输出流未被重定向的原始控制台中使用，在 Eclipse 或者其他 IDE 的控制台是用不了的。
     */


    public static void main(String[] args) {
        Console cs = System.console();
        System.out.println("Enter your name:");
        String name = cs.readLine();
        System.out.println("Welcome " + name);

        System.out.println("Enter your password:");
        // 读取密码
        char[] ch = cs.readPassword();
        String password = String.valueOf(ch);
        System.out.println("Password is: " + password);
    }
}
