package cn.bravedawn.io.file.fileappend;

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
 * @date : Created in 2023/2/9 17:58
 */
public class FileAppend1{

    /**
     * 通过Files.write追加文件内容
     */

    private static final String NEW_LINE = System.lineSeparator();

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/Users/depers/newFile.txt");
        appendToFile(path, "hello world" + NEW_LINE);

    }

    // Java 7
    private static void appendToFile(Path path, String content)
            throws IOException {
        // if file not exists throws java.nio.file.NoSuchFileException
        // Files.write(path, content.getBytes(StandardCharsets.UTF_8),
		// 				StandardOpenOption.APPEND);

        // 更好的解决方案总是结合 StandardOpenOption.CREATE 和 StandardOpenOption.APPEND。
        // 如果文件不存在，API 将创建文件并将文本写入文件； 如果文件存在，将文本追加到文件末尾。
        Files.write(path, content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);

    }

}
