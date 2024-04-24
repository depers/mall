package cn.bravedawn.io.file.readfiletostring;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/3 14:26
 */
public class ApacheCommonsIoExample {

    /**
     * Java使用Apache Commons IO FileUtils类将文件读取为字符串
     * @param args
     */

    public static void main(String[] args) throws IOException {
        File file = new File(Thread.currentThread().getContextClassLoader().getResource("doc/test.txt").getPath());

        String content = FileUtils.readFileToString(new File(file.toURI()), StandardCharsets.UTF_8);

        System.out.println(content);
    }
}
