package cn.bravedawn.io;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

public class CharsetExample {

    public static void main(String[] args) {
        Charset cs = Charset.defaultCharset();
        System.out.println(cs);
    }
}
