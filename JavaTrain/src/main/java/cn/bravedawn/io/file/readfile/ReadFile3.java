package cn.bravedawn.io.file.readfile;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/8 21:56
 */
public class ReadFile3 {

    /**
     * 本例使用Java7 Files.readAllBytes将文件读入字节数组byte[]，如果读取文件大小超过2G，
     * 会抛出java.lang.OutOfMemoryError: Required array size too large。
     */

    public static void main(String[] args) throws IOException {
        String fileName = ResourceHelper.getAbsoluteFilePath("doc/test.txt");

        byte[] bytes = Files.readAllBytes(Paths.get(fileName));
        String content = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(content);
    }
}
