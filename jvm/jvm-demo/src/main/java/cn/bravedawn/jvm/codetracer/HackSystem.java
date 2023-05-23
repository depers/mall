package cn.bravedawn.jvm.codetracer;

import java.io.*;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/5/22 17:17
 */
public class HackSystem {

    /**
     * 劫持System，将out进行覆盖，将其输出到文件中
     */

    public static PrintStream out;

    static {
        try {
            out = new PrintStream(new File("/Users/depers/Desktop/code/mall/jvm/jvm-demo/src/main/resources/out.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
