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
 * @date : Created in 2023/2/7 17:55
 */
public class ReadFile1ToList {


    /**
     * 为了读取一个小文本文件，我们可以使用 collect 轻松地将 Stream 转换为 List<String>。
     */
    public static void main(String[] args) throws IOException {
        String fileName = ResourceHelper.getAbsoluteFilePath("doc/test.txt");

        // auto-close the resources
        Stream<String> lines = Files.lines(Paths.get(fileName));

        // only for small text file
        List<String> collect = lines.collect(Collectors.toList());

        System.out.println(collect);
    }
}
