package cn.bravedawn.io.file.readfile;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/8 21:58
 */
public class ReadFile4 {

    /**
     * 本例使用Java8 Files.readAllLines将文件读入List<String>，如果文件大小大于运行的JVM堆大小，
     * 将抛出java.lang.OutOfMemoryError: Java heap space
     */

    public static void main(String[] args) throws IOException {
        String fileName = ResourceHelper.getAbsoluteFilePath("doc/test.txt");


        List<String> lines = Files.readAllLines(Paths.get(fileName),
                StandardCharsets.UTF_8);
        lines.forEach(System.out::println);
    }
}
