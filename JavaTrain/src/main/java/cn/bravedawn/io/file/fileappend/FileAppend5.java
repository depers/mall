package cn.bravedawn.io.file.fileappend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/9 20:00
 */
public class FileAppend5 {

    /**
     * 通过FileOutputStream将字符串写入文件
     */

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/depers/newFile2.txt");
        appendToFileFileOutputStream(file, "hello world2");
        System.out.println("Done");
    }


    private static void appendToFileFileOutputStream(File file, String content)
            throws IOException {

        // append mode
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(content.getBytes(StandardCharsets.UTF_8));
        }

    }
}
