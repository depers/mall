package cn.bravedawn.io.tmp;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author : depers
 * @program : 2.JavaTrain
 * @date : Created in 2024/3/26 21:06
 *
 * 使用NIO创建临时文件
 */
public class TmpFileExample {

    public static void main(String[] args) {

        // Java NIO
        try {
            Path temp = Files.createTempFile("", ".tmp");

            String absolutePath = temp.toString();
            System.out.println("Temp file : " + absolutePath);

            String separator = FileSystems.getDefault().getSeparator();
            String tempFilePath = absolutePath
                    .substring(0, absolutePath.lastIndexOf(separator));

            System.out.println("Temp file path : " + tempFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
