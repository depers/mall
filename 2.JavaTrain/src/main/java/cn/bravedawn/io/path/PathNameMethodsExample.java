package cn.bravedawn.io.path;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-08 15:44
 */
public class PathNameMethodsExample {

    /**
     * 映射功能：获取文件的路径
     */


    public static void main(String[] args) throws IOException {
        Path path = Paths.get("");
        File file = new File("");

        // java.io API
        String absolutePathStr = file.getAbsolutePath();
        String canonicalPathStr = file.getCanonicalPath();

        // java.nio API
        Path absolutePath = path.toAbsolutePath();
        Path canonicalPath = path.toRealPath().normalize();

        // 转换为URI
        URI fileUri = file.toURI();
        URI pathUri = path.toUri();

        // 列出目录内容
        // java.io API
        String[] list = file.list();
        File[] files = file.listFiles();

        // java.nio API
        DirectoryStream<Path> paths = Files.newDirectoryStream(path);
    }
}
