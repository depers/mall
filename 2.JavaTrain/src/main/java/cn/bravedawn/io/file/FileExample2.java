package cn.bravedawn.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/8/31 17:43
 */
public class FileExample2 {

    /**
     * 使用 java.nio.file.Files (现代NIO) 提供的API判断一个文件或是目录是否存在，两种办法
     * 1. Files.exists(path)
     * 2. Files.isRegularFile(file)或是Files.exists(directory)
     */

    public static void main(String[] args) throws IOException {

        // 判断一个文件是否存在
        Path path = Paths.get("does-not-exist.txt");
        boolean exists = Files.exists(path);
        System.out.println(exists); // false


        // 创建一个临时文件，判断一个文件是否存在
        Path tempFile = Files.createTempFile("baeldung", "exist-article");
        boolean exists1 = Files.exists(tempFile);
        System.out.println(exists1); // true


        // 判断一个目录是否存在
        Path tempDirectory = Files.createTempDirectory("baeldung-exists");
        System.out.println(Files.exists(tempDirectory)); // true

        // 如果我们想确认文件或目录是否存在且可以确认它是文件还是目录，我们可以使用Files.isDirectory()和Files.isRegularFile()方法
        System.out.println(Files.isDirectory(tempDirectory)); // true
        System.out.println(Files.isDirectory(tempFile));  // false
        System.out.println(Files.isRegularFile(tempFile)); // true

        // 如果Path不存在则返回true
        System.out.println(Files.notExists(tempDirectory)); // false

        System.out.println(Files.isReadable(tempFile)); // true

        // 下面的这个文件，我在windows上设置了不可读
        Path winNotReadableFile = Paths.get("C:\\Users\\depers\\Desktop\\Netty-20220729.md");
        System.out.println(Files.isReadable(winNotReadableFile)); // false
        // 对于不可读的文件，使用exists()方法也会返回false
        System.out.println(Files.exists(winNotReadableFile)); // false

    }
}
