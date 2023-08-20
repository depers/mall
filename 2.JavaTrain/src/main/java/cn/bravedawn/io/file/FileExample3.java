package cn.bravedawn.io.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/8/31 20:56
 */
public class FileExample3 {

    /**
     * 这里讨论了使用java.nio.file.Files (现代NIO) 提供的API判断符号链接是否存在
     */


    public static void main(String[] args) throws IOException {
        Path target = Files.createTempFile("baeldung", "target");
        Path symbol = Paths.get("test-link-" + ThreadLocalRandom.current().nextInt());

        // 这里你必须在windows上使用管理员权限进行运行，否则会报：FileSystemException(A required privilege is not held by the client.)
        Path symbolicLink = Files.createSymbolicLink(symbol, target);
        System.out.println(Files.exists(symbolicLink)); // true

        // 若符号链接指向的文件被删除了，Files.exists(符号链接)返回false
        Files.deleteIfExists(target);
        System.out.println(Files.exists(symbolicLink)); // false

        // 通过传递合适的LinkOption作为第二参数，其实是可以不遵循符号链接的。因为符号链接文件本身自己存在，所以这里返回true
        System.out.println(Files.exists(symbolicLink, LinkOption.NOFOLLOW_LINKS)); // true
        // 使用Files.isSymbolicLink(Path)方法检查 Path 是否是符号链接
        System.out.println(Files.isSymbolicLink(symbolicLink)); // true

    }
}
