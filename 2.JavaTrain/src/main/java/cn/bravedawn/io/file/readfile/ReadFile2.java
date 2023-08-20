package cn.bravedawn.io.file.readfile;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/8 13:27
 */
public class ReadFile2 {


    /**
     * 方式二：
     * Java11 Files.readString()把一个文件读成一个字符串，如果读入的文件大小超过2G，
     * 就会抛出java.lang.OutOfMemoryError: Required array size too large。
     *
     * 值得注意的是：
     * 查看源代码，新的 Java 11 readString，内部使用现有的 Java 7 readAllBytes
     * 将文件读入 byte[] 和 JLA.newStringNoRepl 将 byte[] 转换回字符串。
     */

    public static void main(String[] args) throws IOException {
        String fileName = ResourceHelper.getAbsoluteFilePath("doc/test.txt");

        // default UTF_8
        String s = Files.readString(Paths.get(fileName));
        System.out.println(s);

        // String s = Files.readString(Paths.get(fileName), StandardCharsets.UTF_8);
    }
}
