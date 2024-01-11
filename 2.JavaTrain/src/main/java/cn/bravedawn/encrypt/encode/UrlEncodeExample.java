package cn.bravedawn.encrypt.encode;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlEncodeExample {

    /**
     * 用来解决浏览器发送数据给服务器时，url参数不能正确的传递中文的问题，有些服务器只识别Ascii字符
     * URLEncoder.encode(): 使用指定的编码机制将字符串转换为 application/x-www-form-urlencoded 格式。
     * URLDecoder.decode(): 使用指定的编码机制对 application/x-www-form-urlencoded 字符串解码。
     */

    public static void main(String[] args) {
        String encoded = URLEncoder.encode("中文！", StandardCharsets.UTF_8);
        System.out.println(encoded);

        String decoded = URLDecoder.decode(encoded, StandardCharsets.UTF_8);
        System.out.println(decoded);
    }
}
