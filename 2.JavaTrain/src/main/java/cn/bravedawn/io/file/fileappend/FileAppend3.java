package cn.bravedawn.io.file.fileappend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/9 19:47
 */
public class FileAppend3 {

    /**
     * 通过Java11 Files.writeString将字符串直接写入到文件中
     */

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/depers/newFile.txt");
        appendToFileJava11(path, "你好");
    }

    private static void appendToFileJava11(Path path, String content)
            throws IOException {

        // utf_8
      /*Files.writeString(path, content, StandardCharsets.UTF_8,
              StandardOpenOption.CREATE,
              StandardOpenOption.APPEND);*/

        // default StandardCharsets.UTF_8
        Files.writeString(path, content,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

}
