package cn.bravedawn.basic.lang.string.charset;

import java.nio.charset.Charset;

/**
 * @author : depers
 * @description :
 * @program : 2.JavaTrain
 * @date : Created in 2024/1/7 21:48
 */
public class CharsetExample {

    /**
     * Java提供的编码操作的类
     */

    public static void main(String[] args) {
        String defaultProperty = System.getProperty("file.encoding");
        System.out.println(defaultProperty);

        Charset gbk = Charset.forName("GBK");
        System.out.println(gbk.toString());
    }
}
