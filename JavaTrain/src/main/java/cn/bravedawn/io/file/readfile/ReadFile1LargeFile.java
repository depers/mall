package cn.bravedawn.io.file.readfile;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/7 17:58
 */
public class ReadFile1LargeFile {


    /**
     * 对于大文本文件的读取，如果行的顺序无关紧要，我们可以开启Stream的并行特性，进一步提高读取速度。
     */

    public static void main(String[] args) throws IOException {
        // a large text file, for example, 10G
        String fileName = ResourceHelper.getAbsoluteFilePath("doc/test.txt");

        Stream<String> lines = Files.lines(Paths.get(fileName));

        // parallel
        lines.parallel().forEach(l -> {
            /* do work */
            System.out.println(l);
        });
    }
}
