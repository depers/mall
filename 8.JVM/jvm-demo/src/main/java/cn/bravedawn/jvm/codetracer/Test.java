package cn.bravedawn.jvm.codetracer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/5/22 18:42
 */
public class Test {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/depers/Desktop/code/mall/jvm/jvm-demo/target/classes/cn/bravedawn/jvm/codetracer/Plus.class";
        InputStream is = new FileInputStream(fileName);
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();
        JavaClassExecuter.execute(b);
    }



}
