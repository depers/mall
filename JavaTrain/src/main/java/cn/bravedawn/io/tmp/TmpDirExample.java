package cn.bravedawn.io.tmp;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/3/26 21:05
 *
 * 获取系统的临时目录
 *
 */
public class TmpDirExample {

    public static void main(String[] args) {
        String tmpdir = System.getProperty("java.io.tmpdir");
        System.out.println("Temp file path: " + tmpdir);
    }
}
