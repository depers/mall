package cn.bravedawn.encrypt.encode;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlEncodeExample {

    public static void main(String[] args) {
        String encoded = URLEncoder.encode("中文！", StandardCharsets.UTF_8);
        System.out.println(encoded);

        String decoded = URLDecoder.decode(encoded, StandardCharsets.UTF_8);
        System.out.println(decoded);
    }
}
