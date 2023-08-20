package cn.bravedawn.io.file.createfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/9 16:57
 */
public class CreateFile5 {

    /**
     * 在 Java 11 中，我们可以使用名为 Files.writeString 的新 API 将字符串或文本直接写入文件。
     */

    public static void main(String[] args) throws IOException {

        String fileName = "/Users/depers/newFile.txt";
        String content = "1212";
        // default utf_8
        // file does not exists, create and write it
        // if the file exists, override the content
        Files.writeString(Paths.get(fileName), content);

        // Append mode
        // Files.writeString(path, content,
        //	StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
