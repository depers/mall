package cn.bravedawn.io.file.createfile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/7 11:39
 */
public class CreateFileJava8 {

    /**
     * 方法一：使用Java8的Files.newBuffered创建文件，并写入内容
     *
     * 其中该API通过try-with-resources实现自动关闭
     */

    public static void main(String[] args) {

        String fileName = "/Users/depers/newFile.txt";

        Path path = Paths.get(fileName);

        // default, create, truncate and write to it.
        try (BufferedWriter writer =
                     Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            writer.write("Hello World !!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Append mode. 在文件原有文本后面追加内容(前提是文件已存在)
        try (BufferedWriter writer =
                     Files.newBufferedWriter(path,
                             StandardCharsets.UTF_8,
                             StandardOpenOption.APPEND)){

            writer.write("Hello World !!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
