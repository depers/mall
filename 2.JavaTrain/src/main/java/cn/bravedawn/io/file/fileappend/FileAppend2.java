package cn.bravedawn.io.file.fileappend;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/9 19:43
 */
public class FileAppend2 {

    /**
     * 追加多行到一个文件中
     */

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/depers/newFile.txt");
        List<String> list = List.of("a", "b", "c");
        appendToFileJava8(path, list);
    }


    private static void appendToFileJava8(Path path, List<String> list)
            throws IOException {

        // Java 7
        /*Files.write(path, list, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);*/

        // Java 8, default utf_8
        Files.write(path, list,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);

    }
}
