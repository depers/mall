package cn.bravedawn.io.file.directory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-01-11 10:49
 */
public class CreateDirectoryExample {


    public static void main(String[] args) throws IOException {
        // 创建目录，若文件存在会抛出异常
        Files.createDirectory(Paths.get("E://test"));
    }
}
