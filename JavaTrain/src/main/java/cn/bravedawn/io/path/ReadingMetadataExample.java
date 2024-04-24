package cn.bravedawn.io.path;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-08 15:41
 */
public class ReadingMetadataExample {

    /**
     * 映射功能：读取元数据
     */


    public static void main(String[] args) throws IOException {
        Path path = Paths.get("");
        File file = new File("");

        // java.io API
        boolean fileExists = file.exists();
        boolean fileIsFile = file.isFile();
        boolean fileIsDir = file.isDirectory();
        boolean fileReadable = file.canRead();
        boolean fileWritable = file.canWrite();
        boolean fileExecutable = file.canExecute();
        boolean fileHidden = file.isHidden();

        // java.nio API
        boolean pathExists = Files.exists(path);
        boolean pathIsFile = Files.isRegularFile(path);
        boolean pathIsDir = Files.isDirectory(path);
        boolean pathReadable = Files.isReadable(path);
        boolean pathWritable = Files.isWritable(path);
        boolean pathExecutable = Files.isExecutable(path);
        boolean pathHidden = Files.isHidden(path);
    }
}
