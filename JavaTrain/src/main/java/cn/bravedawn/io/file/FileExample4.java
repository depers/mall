package cn.bravedawn.io.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/8/31 21:15
 */
public class FileExample4 {

    /**
     * 使用原有的 java.io.File (遗留IO)提供的API判断一个文件或是目录是否存在
     */
    public static void main(String[] args) throws IOException {
        // 通过File实例去判断文件是否存在
        System.out.println(new File("invalid").exists()); // false

        // 如果文件和目录存在的话，file.exists()将返回true
        Path tempFilePath = Files.createTempFile("baeldung", "exist-io");
        Path tempDirectoryPath = Files.createTempDirectory("baeldung-exists-io");

        File tempFile = new File(tempFilePath.toString());
        File tempDirectory = new File(tempDirectoryPath.toString());

        // 正如下面所示，file.exists()方法不关心它是目录还是文件，只要存在就返回true
        System.out.println(tempFile.exists()); // true
        System.out.println(tempDirectory.exists()); // true

        // 如果他是一个存在的文件，isFile()就会返回true
        System.out.println(tempFile.isFile()); // true
        System.out.println(tempDirectory.isFile()); // false

        // 如果他是一个存在的目录，isDirectory就会返回true
        System.out.println(tempFile.isDirectory()); // false
        System.out.println(tempDirectory.isDirectory()); // true

        // 如果文件是可读的，canRead就会返回true
        System.out.println(tempFile.canRead()); // true
        System.out.println(new File("C:\\Users\\depers\\Desktop\\Netty-20220729.md").canRead()); // true
    }
}
