package cn.bravedawn;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: 应用层
 * @date : Created in 2021/1/9 16:23
 */
public class Test {

    private static final String USER_DIR = "user.dir";


    //public static void main(String[] args) {
    //    System.out.println(System.getProperty(USER_DIR));
    //
    //    System.out.println(Charset.defaultCharset());
    //
    //    System.out.println(Charset.availableCharsets().toString());
    //
    //    System.out.println(StandardCharsets.UTF_8);
    //
    //    System.out.println(Charset.forName("UTF-8"));
    //}


    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
    }
}
