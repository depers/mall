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

@Log4j
public class StringExample6 {


    public static void main(String[] args) throws UnsupportedEncodingException {
        //获取系统默认编码
        log.info("系统默认编码：" + System.getProperty("file.encoding"));
        //系统默认字符编码
        log.info("系统默认字符编码:" + Charset.defaultCharset());
        //操作系统用户使用的语言
        log.info("系统默认语言:" + System.getProperty("user.language"));

        //-------------------------------------------------------------
        String a = "冯晓";
        System.out.println(Arrays.toString(a.getBytes()));
        System.out.println(getEncode(a));
        System.out.println(new String(a.getBytes(), "GBK"));
    }



    public static final String[] ENCODES = new String[]{"UTF-8", "GBK", "GB2312", "ISO-8859-1", "ISO-8859-2"};

    /**
     * 获取字符串是什么编码，例如返回的值有：UTF-8，GBK，ISO-8859-1等
     *
     * @param str
     * @return
     */
    public static String getEncode(String str) {
        byte[] data = str.getBytes();
        byte[] b = null;
        a:
        for (int i = 0; i < ENCODES.length; i++) {
            try {
                b = str.getBytes(ENCODES[i]);
                if (b.length != data.length) {
                    continue;
                }
                for (int j = 0; j < b.length; j++) {
                    if (b[j] != data[j]) {
                        continue a;
                    }
                }
                return ENCODES[i];
            } catch (UnsupportedEncodingException e) {
                continue;
            }
        }
        return null;
    }
}
