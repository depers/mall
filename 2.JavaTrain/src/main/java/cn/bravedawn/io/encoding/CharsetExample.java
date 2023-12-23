package cn.bravedawn.io.encoding;

import java.nio.charset.Charset;

public class CharsetExample {

    public static void main(String[] args) {
        Charset cs = Charset.defaultCharset();
        System.out.println(cs);
    }
}
