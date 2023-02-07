package cn.bravedawn.io.file.readfile;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/7 21:51
 */
public class ReadFile1LargeFileError {

    /**
     * 一个常见的错误是将一个大的Stream直接转换成List，
     * 如果Stream的大小大于运行的JVM堆大小，会抛出java.lang.OutOfMemoryError: Java heap space。
     */


    public static void main(String[] args) throws IOException {
        // a large text file, for example, 10G
        String fileName = ResourceHelper.getAbsoluteFilePath("doc/test.txt");

        Stream<String> lines = Files.lines(Paths.get(fileName));

        // java.lang.OutOfMemoryError: Java heap space
        List<String> collect = lines.collect(Collectors.toList());
    }
}
