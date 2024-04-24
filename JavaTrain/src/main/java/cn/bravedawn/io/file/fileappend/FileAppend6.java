package cn.bravedawn.io.file.fileappend;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/9 20:02
 */
public class FileAppend6 {

    /**
     * 使用Apache commons-io的Files.writeStringToFile()追加字符串内容到文件中
     */

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/depers/newFile2.txt");
        appendToFileFileUtils(file, "hello world2");
        System.out.println("Done");
    }


    private static void appendToFileFileUtils(File file, String content)
            throws IOException {

        // append mode
        FileUtils.writeStringToFile(
                file, content, StandardCharsets.UTF_8, true);

    }
}
