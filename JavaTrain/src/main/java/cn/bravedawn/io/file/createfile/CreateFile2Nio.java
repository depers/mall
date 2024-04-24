package cn.bravedawn.io.file.createfile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/7 13:24
 */
public class CreateFile2Nio {

    /**
     * 方法二：Java7 Files.write()，会自动创建和补充文件内容
     * Files.write()方法内部通过try-with-resources会自动关闭，推荐使用
     */


    public static void main(String[] args) {
        String fileName = "newFile.txt";
        String content = "hello world!";

        try {

            // Java 1.7
            // default, create and write to it.
            Files.write(
                    Paths.get(fileName),
                    content.getBytes(StandardCharsets.UTF_8));

            // Append content
            /*Files.write(
                    Paths.get(fileName),
                    content.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
