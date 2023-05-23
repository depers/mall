package cn.bravedawn.io.systemout;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/5/23 16:56
 */
public class WhilePrint {

    /**
     * 这是一个死循环程序，将内容输出到标准输出上
     */

    public static void main(String[] args) {
        while (true) {
            System.out.println("此刻的时间是：" + System.currentTimeMillis());
        }
    }
}
