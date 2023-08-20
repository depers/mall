package cn.bravedawn.io.file.readfiletostring;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/3 14:23
 */
public class ScannerExample {

    /**
     * 使用Scanner类将文件读取到String
     * @param args
     */

    public static void main(String[] args) throws IOException {

        File file = new File(Thread.currentThread().getContextClassLoader().getResource("doc/test.txt").getPath());
        Scanner scanner = new Scanner(Paths.get(file.toURI()), StandardCharsets.UTF_8.name());
        String content = scanner.useDelimiter("\\A").next();
        scanner.close();

        System.out.println(content);
    }
}
