package cn.bravedawn.basic.lang.string;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/7/6 22:39
 */

@Slf4j
public class StringExample6 {

    /**
     * String编码的讨论
     */


    public static void main(String[] args) throws UnsupportedEncodingException {
        //获取系统默认编码
        log.info("系统默认编码：" + System.getProperty("file.encoding"));
        //系统默认字符编码
        log.info("系统默认字符编码:" + Charset.defaultCharset());
        //操作系统用户使用的语言
        log.info("系统默认语言:" + System.getProperty("user.language"));

        //-------------------------------------------------------------
        // 用什么编码方式编码就用什么编码方式解码，字符串才能正确的表示
        String a = "冯晓";
        byte[] aByteArray = a.getBytes("GBK"); // 字符串编码
        String aStr = new String(aByteArray, "GBK"); // 字符串解码

        System.out.println(Arrays.toString(a.getBytes("GBK")));
        System.out.println(new String(a.getBytes("GBK"), "GBK"));
    }




}
