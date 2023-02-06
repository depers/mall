package cn.bravedawn.io.file.readfiletostring;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/3 14:19
 */
public class FilesExample {

    /**
     * Java使用Files类将文件读取为字符串
     */


    public static void main(String[] args) throws URISyntaxException, IOException {
        File file = new File(Thread.currentThread().getContextClassLoader().getResource("doc/test.txt").getPath());

        // Files.readAllBytes 请注意，此方法适用于方便将所有字节读入字节数组的简单情况。 它不适用于读取大文件。
        String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
        System.out.println(content);

    }
}
